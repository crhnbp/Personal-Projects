import java.util.HashSet;
import java.util.Set;

public class Node {
    private long id;
    private double lat;
    private double lon;
    private boolean disconnected;
    Set<Node> connectionSet;

    public Node(long id, double lat, double lon) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        connectionSet = new HashSet<>();
        disconnected = true;
    }

    public boolean isDisconnected() {
        return disconnected;
    }

    public Set<Node> getConnectionSet() {
        return connectionSet;
    }

    public long getID() {
        return id;
    }
    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }
    public double getEuclDistTo(Node n) {
        double diff1 = this.getLat() - n.getLat();
        double diff2 = this.getLon() - n.getLon();
        return Math.sqrt(diff1 * diff1 + diff2 * diff2);
    }
    public void setIsDisconnected() {
        disconnected = false;
    }
    public void addToConnections(Node n) {
        connectionSet.add(n);
    }

    public void connect(Node n) {
        if (n != null) {
            addToConnections(n);
            setIsDisconnected();
            n.addToConnections(this);
            n.setIsDisconnected();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node node = (Node) o;
        if (id != node.id) {
            return false;
        }
        if (Double.compare(node.lat, lat) != 0) {
            return false;
        }
        return Double.compare(node.lon, lon) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
