import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
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
    private static LinkedList<Long> route;


    private static double getDist(Node n, double targetLon, double targetLat) {
        double diff1 = n.getLat() - targetLat;
        double diff2 = n.getLon() - targetLon;
        return Math.sqrt(diff1 * diff1 + diff2 * diff2);
    }

    private static ArrayList<Node> startEnd(GraphDB g, double slon, double slat,
                                                     double elon, double elat) {
        ArrayList<Node> x = new ArrayList<>();
        double startDist = 0;
        double endDist = 0;
        Node start = null;
        Node end = null;
        Map<Long, Node> graph = g.getGraph();
        Iterator<Map.Entry<Long, Node>> iter = graph.entrySet().iterator();
        if (iter.hasNext()) {
            Map.Entry<Long, Node> entry = iter.next();
            start = entry.getValue();
            end = entry.getValue();
            startDist = getDist(start, slon, slat);
            endDist = getDist(end, elon, elat);
        }
        while (iter.hasNext()) {
            Map.Entry<Long, Node> entry = iter.next();
            Node y = entry.getValue();
            double yDistToStart = getDist(y, slon, slat);
            double yDistToEnd = getDist(y, elon, elat);
            if (yDistToStart < startDist) {
                startDist = yDistToStart;
                start = y;
            }
            if (yDistToEnd < endDist) {
                endDist = yDistToEnd;
                end = y;
            }
        }
        x.add(start);
        x.add(end);
        return x;
    }
    
    public static LinkedList<Long> shortestPath(GraphDB g, double stlon,
                                                 double stlat, double destlon, double destlat) {
        double startLat = stlat;
        double startLon = stlon;
        double endLat = destlat;
        double endLon = destlon;
        ArrayList<Node> startEndNodes = startEnd(g, startLon, startLat, endLon, endLat);
        Node startNode = startEndNodes.get(0);
        System.out.println(startNode.getID());
        Node endNode = startEndNodes.get(1);
        HashMap<Node, Node> map = astar(startNode, endNode);
        route = new LinkedList<>();
        Node currNode = endNode;
        System.out.println(currNode.getID());

        Node prevNode = map.get(currNode);
        while (!currNode.equals(startNode)) {
            long id = currNode.getID();
            route.addFirst(id);
            currNode = prevNode;
            if (currNode == null) {
                break;
            }
            prevNode = map.get(currNode);
        }
        if (currNode != null) {
            route.addFirst(currNode.getID());
        }
        return route;

    }

    private static HashMap<Node, Node> astar(Node startNode, Node endNode) {
        HashSet<Node> visited = new HashSet<>();
        HashMap<Node, Node> map = new HashMap<>();  
        PriorityQueue<WrapperNode> prio = new PriorityQueue<>();            
        HashMap<Node, Double> dist = new HashMap<>();
        WrapperNode wstart = new WrapperNode(startNode, endNode, 0.0);
        prio.add(wstart);
        dist.put(startNode, 0.0);
        while (!prio.isEmpty()) {
            WrapperNode z = prio.remove();
            Node v = z.getNode();
            if (visited.contains(v)) {
                continue;
            }
            visited.add(v);
            if (v.equals(endNode)) {
                break;
            }
            Set<Node> children = v.getConnectionSet();
            for (Node child: children) {
                double edge = v.getEuclDistTo(child);
                if (!dist.containsKey(child) || dist.get(child) >= dist.get(v) + edge) {
                    dist.put(child, dist.get(v) + edge);                       
                    prio.add(new WrapperNode(child, endNode, dist.get(child))); 
                    map.put(child, v);                                    
                }
            }
        }
        return map;
    }
}
