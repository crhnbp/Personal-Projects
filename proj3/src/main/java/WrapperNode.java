
public class WrapperNode implements Comparable<WrapperNode> {
    Node n;
    Node t;
    double distToStart;

    public WrapperNode(Node n, Node t, double distToStart) {
        this.n = n;
        this.t = t;
        this.distToStart = distToStart;

    }
    public Node getNode() {
        return n;
    }

    public double getPriorty() {
        return distToStart + n.getEuclDistTo(t);
    }

    @Override
    public int compareTo(WrapperNode other) {
        double priority1 = getPriorty();
        double priority2 = other.getPriorty();
        if (priority1 < priority2) {
            return -1;
        } else if (priority1 > priority2) {
            return 1;
        } else {
            return 0;
        }
    }
}
