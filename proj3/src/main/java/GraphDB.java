import org.xml.sax.SAXException;
import com.sun.org.apache.xml.internal.utils.Trie;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.*;

/**
 * Graph for storing all of the intersection (vertex) and road (edge) information.
 * Uses your GraphBuildingHandler to convert the XML files into a graph. Your
 * code must include the vertices, adjacent, distance, closest, lat, and lon
 * methods. You'll also need to include instance variables and methods for
 * modifying the graph (e.g. addNode and addEdge).
 *
 * @author Alan Yao, Josh Hug
 */
public class GraphDB {
    /** Your instance variables for storing the graph. You should consider
     * creating helper classes, e.g. Node, Edge, etc. */

    /**
     * Example constructor shows how to create and start an XML parser.
     * You do not need to modify this constructor, but you're welcome to do so.
     * @param dbPath Path to the XML file to be parsed.
     */
    public HashMap<Long, Node> graph;
    public TrieST trieTree;

    public GraphDB(String dbPath) {
        graph = new HashMap<>();
        try {
            File inputFile = new File(dbPath);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            GraphBuildingHandler graphhandler = new GraphBuildingHandler(this);
            saxParser.parse(inputFile, graphhandler);
            // Get a TrieST of the nodes
            TrieST trieTree = new TrieST(graphhandler.getNodeSet());



            // Use these two sets of info to construct a graph.
//            System.out.println(maphandler.getNodeSet().get((long) 286080658).getLat());
            // We can do this in the connection class;
//            System.out.println(maphandler.getWayMap().size());

//            System.out.println("import size: " + maphandler.getWayMap().size());
//            System.out.println(maphandler.getWayMap().get((long) 5149907));
//            Connection connect = new Connection(maphandler.getNodeSet(), maphandler.getWayMap());
//            // Then get a graph
//            graph = connect.getGraph();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        clean();
    }

    /**
     * Helper to process strings into their "cleaned" form, ignoring punctuation and capitalization.
     * @param s Input string.
     * @return Cleaned string.
     */
    static String cleanString(String s) {
        return s.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    }

    public TrieST getTrieTree() {
        return this.trieTree;
    }

    /**
     *  Remove nodes with no connections from the graph.
     *  While this does not guarantee that any two nodes in the remaining graph are connected,
     *  we can reasonably assume this since typically roads are connected.
     */
    private void clean() {
        // TODO: Your code here.
    }

    /** Returns an iterable of all vertex IDs in the graph. */
    Iterable<Long> vertices() {
        //YOUR CODE HERE, this currently returns only an empty list.
        return new ArrayList<Long>();
    }

    /** Returns ids of all vertices adjacent to v. */
    Iterable<Long> adjacent(long v) {
        return null;
    }

    /** Returns the distance in units of longitude between vertices v and w. */
    double distance(long v, long w) {
        return 0;
    }

    /** Returns the vertex id closest to the given longitude and latitude. */
    long closest(double lon, double lat) {
        return 0;
    }

    /** Longitude of vertex v. */
    double lon(long v) {
        return 0;
    }

    /** Latitude of vertex v. */
    double lat(long v) {
        return 0;
    }
}
