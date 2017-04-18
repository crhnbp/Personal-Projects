import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.List;
import java.util.Base64;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Iterator;

/**
 * This class provides a shortestPath method for finding routes between two points
 * on the map. Start by using Dijkstra's, and if your code isn't fast enough for your
 * satisfaction (or the autograder), upgrade your implementation by switching it to A*.
 * Your code will probably not be fast enough to pass the autograder unless you use A*.
 * The difference between A* and Dijkstra's is only a couple of lines of code, and boils
 * down to the priority you use to order your vertices.
 */
public class Router {
    /**
     * Return a LinkedList of <code>Node</code>s representing the shortest path from st to dest.
     */
    private static LinkedList<Long> routeIDs;
    private static GraphDB g;


    private static double getDist(Node n, double targetLon, double targetLat) {
        double diff1 = n.getLat() - targetLat;
        double diff2 = n.getLon() - targetLon;
        return Math.sqrt(diff1 * diff1 + diff2 * diff2);
    }

    private static ArrayList<Node> findStartEndNodes(GraphDB g, double slon, double slat,
                                                     double elon, double elat) {
        ArrayList<Node> arr = new ArrayList<>();
        Map<Long, Node> graph = g.getGraph();
        Node startNode = null;
        Node endNode = null;
        double startDist = 0;
        double endDist = 0;
        Iterator<Map.Entry<Long, Node>> iter = graph.entrySet().iterator();
        if (iter.hasNext()) {
            Map.Entry<Long, Node> entry = iter.next();
            startNode = entry.getValue();
            endNode = entry.getValue();
            startDist = getDist(startNode, slon, slat);
            endDist = getDist(endNode, elon, elat);
        }
        while (iter.hasNext()) {
            Map.Entry<Long, Node> entry = iter.next();

            Node temp = entry.getValue();

            double tempDistToStart = getDist(temp, slon, slat);
            double tempDistToEnd = getDist(temp, elon, elat);
            if (tempDistToStart < startDist) {
                startDist = tempDistToStart;
                startNode = temp;
            }
            if (tempDistToEnd < endDist) {
                endDist = tempDistToEnd;
                endNode = temp;
            }
        }
        arr.add(startNode);
        arr.add(endNode);
        return arr;
    }
    
    public static LinkedList<Long> shortestPath(GraphDB g, double stlon, double stlat, double destlon, double destlat) {
        double startLat = stlat;
        double startLon = stlon;
        double endLat = destlat;
        double endLon = destlon;
        this.g = g;
        ArrayList<Node> startEndNodes = findStartEndNodes(g, startLon, startLat, endLon, endLat);
        Node startNode = startEndNodes.get(0);
        Node endNode = startEndNodes.get(1);
        HashMap<Node, Node> prev = performAStar(startNode, endNode);
        routeIDs = new LinkedList<>();
        Node currNode = endNode;
        Node prevNode = prev.get(currNode);
        while (!currNode.equals(startNode)) {
            long id = currNode.getID();
            routeIDs.addFirst(id);
            currNode = prevNode;
            prevNode = prev.get(currNode);
        }
        routeIDs.addFirst(currNode.getID());
        return routeIDs;

    }

    private static HashMap<Node, Node> performAStar(Node startNode, Node endNode) {
        HashSet<Node> visited = new HashSet<>();            // HashSet of nodes
        HashMap<Node, Double> dist = new HashMap<>();       // HashMap of node to pathdist to node
        HashMap<Node, Node> prev = new HashMap<>();         // HashMap of previous pointers
        PriorityQueue<WrapperNode> fringe = new PriorityQueue<>(); // PQ comparing on dist + h(n)
        WrapperNode wStartNode = new WrapperNode(startNode, endNode, 0.0);
        fringe.add(wStartNode);
        dist.put(startNode, 0.0);
        while (!fringe.isEmpty()) {
            WrapperNode wv = fringe.remove();
            Node v = wv.getNode();
            if (visited.contains(v)) {
                continue;
            }
            visited.add(v);
            if (v.equals(endNode)) {
                break;
            }
            ArrayList<Node> children = v.getNeighbors();
            for (Node child: children) {
                double edge = v.getEuclDistTo(child);
                if (!dist.containsKey(child) || dist.get(child) >= dist.get(v) + edge) {
                    dist.put(child, dist.get(v) + edge);                       // update distance
                    fringe.add(new WrapperNode(child, endNode, dist.get(child))); // update pqueue
                    prev.put(child, v);                                    // update back pointers
                }
            }
        }
        return prev;
    }
}
