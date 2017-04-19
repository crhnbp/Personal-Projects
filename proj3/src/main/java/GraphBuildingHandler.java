import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;


/**
 *  Parses OSM XML files using an XML SAX parser. Used to construct the graph of roads for
 *  pathfinding, under some constraints.
 *  See OSM documentation on
 *  <a href="http://wiki.openstreetmap.org/wiki/Key:highway">the highway tag</a>,
 *  <a href="http://wiki.openstreetmap.org/wiki/Way">the way XML element</a>,
 *  <a href="http://wiki.openstreetmap.org/wiki/Node">the node XML element</a>,
 *  and the java
 *  <a href="https://docs.oracle.com/javase/tutorial/jaxp/sax/parsing.html">SAX parser tutorial</a>.
 *  @author Alan Yao
 */
public class GraphBuildingHandler extends DefaultHandler {
    /**
     * Only allow for non-service roads; this prevents going on pedestrian streets as much as
     * possible. Note that in Berkeley, many of the campus roads are tagged as motor vehicle
     * roads, but in practice we walk all over them with such impunity that we forget cars can
     * actually drive on them.
     */
    private static final Set<String> ALLOWED_HIGHWAY_TYPES = new HashSet<>(Arrays.asList
            ("motorway", "trunk", "primary", "secondary", "tertiary", "unclassified",
                    "residential", "living_street", "motorway_link", "trunk_link", "primary_link",
                    "secondary_link", "tertiary_link"));
    private String activeState = "";
    private final GraphDB g;
    private Node n;
    private ArrayList<Node> wayNodes;
    private boolean allowedWay;

    public GraphBuildingHandler(GraphDB g) {
        this.g = g;
    }

    /**
     * Called at the beginning of an element. Typically, you will want to handle each element in
     * here, and you may want to track the parent element.
     * @param uri The Namespace URI, or the empty string if the element has no Namespace URI or
     *            if Namespace processing is not being performed.
     * @param localName The local name (without prefix), or the empty string if Namespace
     *                  processing is not being performed.
     * @param qName The qualified name (with prefix), or the empty string if qualified names are
     *              not available. This tells us which element we're looking at.
     * @param attributes The attributes attached to the element. If there are no attributes, it
     *                   shall be an empty Attributes object.
     * @throws SAXException Any SAX exception, possibly wrapping another exception.
     * @see Attributes
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        /* Some example code on how you might begin to parse XML files. */
        Map<Long, Node> graph = g.getGraph();
        if (qName.equals("node")) {
            activeState = "node";
            long nodeId = Long.parseLong(attributes.getValue("id"));
            double lat = Double.parseDouble(attributes.getValue("lat"));
            double lon = Double.parseDouble(attributes.getValue("lon"));
            n = new Node(nodeId, lat, lon);
            //System.out.println("put node in graph");
            graph.put(nodeId, n);

        } else if (qName.equals("way")) {
            activeState = "way";
            allowedWay = false;
            wayNodes = new ArrayList<>();
            long wayId = Long.parseLong(attributes.getValue("id"));
            //System.out.println("Beginning a way..." + wayId);

        } else if (activeState.equals("way")) {
            if (qName.equals("nd")) { // CONNECT THESE NODES
                long currId = Long.parseLong(attributes.getValue("ref"));
                Node currNode = graph.get(currId);
                wayNodes.add(currNode);

            } else if (qName.equals("tag")) {
                String k = attributes.getValue("k");
                String v = attributes.getValue("v");
                if (k.equals("highway") && ALLOWED_HIGHWAY_TYPES.contains(v)) {
                    allowedWay = true;
                }
                //System.out.println("Tag with k=" + k + ", v=" + v + ".");
            }
        }
        /*else if (activeState.equals("node") && qName.equals("tag")) {
            // DO WE NEED TO DO ANYTHING WITH THE TAGS AFTER A NODE???
            if(attributes.getValue("k").equals("name")) {
                //System.out.println("Node with name: " + attributes.getValue("v"));
            }

        }*/
    }

    /**
     * Receive notification of the end of an element. You may want to take specific terminating
     * actions here, like finalizing vertices or edges found.
     * @param uri The Namespace URI, or the empty string if the element has no Namespace URI or
     *            if Namespace processing is not being performed.
     * @param localName The local name (without prefix), or the empty string if Namespace
     *                  processing is not being performed.
     * @param qName The qualified name (with prefix), or the empty string if qualified names are
     *              not available.
     * @throws SAXException  Any SAX exception, possibly wrapping another exception.
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("way")) {
            if (allowedWay) {
                connectNodes(wayNodes);
                //System.out.println("Finishing a way...");
            } /*else {
                //System.out.println("Finishing a invalid highway way...");
            }*/
        }
    }

    private void connectNodes(ArrayList<Node> nodes) {
        if (nodes.size() > 1) {      // only connects wayNodes if there are at least two
            Node prevNode = nodes.get(0);
            for (int i = 1; i < nodes.size(); i++) {
                Node currNode = nodes.get(i);
                currNode.connect(prevNode);
                prevNode = currNode;
            }
        }
    }
}
