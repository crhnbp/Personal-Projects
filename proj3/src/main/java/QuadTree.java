import java.util.ArrayList;

public class QuadTree {
    private QTreeNode root;
    public final double SIZE = 256;
    public final int MAX_DEPTH = 7;
    public final String PREF =  "img/";
    public final String SUF = ".png";
    public static int row = 0;
    public static int col = 0;

    public QuadTree(double ullat, double ullon, double lrlat, double lrlon, String rootFile) {
        root = new QTreeNode(null, ullat, ullon, lrlat, lrlon, rootFile);
        root.East = null;
        root.South = null;
        root.SE = insert(root, (ullat + lrlat) / 2.0, (ullon + lrlon) / 2.0, lrlat, lrlon, "4");
        root.SW = insert(root, (ullat + lrlat) / 2.0, ullon, lrlat, (ullon + lrlon) / 2.0, "3");
        root.NE = insert(root, ullat, (ullon + lrlon) / 2.0, (ullat + lrlat) / 2.0, lrlon, "2");
        root.NW = insert(root, ullat, ullon, (ullat + lrlat) / 2.0, (ullon + lrlon) / 2.0, "1");
        root.NW.East = root.NE;
        root.NW.South = root.SW;
        root.NE.East = null;
        root.NE.South = root.SE;
        root.SW.East = root.SE;
        root.SW.South = null;
        root.SE.East = null;
        root.SE.South = null;
        setPointer(root.NW);
        setPointer(root.NE);
        setPointer(root.SW);
        setPointer(root.SE);
        
    }
    public void setPointer(QTreeNode x) {
        x.NW.East = x.NE;
        x.NW.South = x.SW;
        x.NE.South = x.SE;
        x.SW.East = x.SE;
        if (x.East != null) {
            x.NE.East = x.East.NW;
        }
        if (x.South != null) {
            x.SW.South = x.South.NW;
        }
        if (x.East != null) {
            x.SE.East = x.East.SW;
        }
        if (x.South != null) {
            x.SE.South = x.South.NE;
        }
        if (!x.NE.hasChild()) {
            return;
        }
        setPointer(x.NW);
        setPointer(x.NE);
        setPointer(x.SW);
        setPointer(x.SE);
    }

    public QTreeNode insert(QTreeNode x, double ullat, double ullon, double lrlat, double lrlon, String filename) {
        if (filename.length() == MAX_DEPTH) {
            return new QTreeNode(x, ullat, ullon, lrlat, lrlon, filename);
        }
        QTreeNode node = new QTreeNode(x, ullat, ullon, lrlat, lrlon, filename);
        node.NW = insert(node, ullat, ullon, (ullat + lrlat) / 2.0, (ullon + lrlon) / 2.0, filename + "1");
        node.NE = insert(node, ullat, (ullon + lrlon) / 2.0, (ullat + lrlat) / 2.0, lrlon, filename + "2");
        node.SW = insert(node, (ullat + lrlat) / 2.0, ullon, lrlat, (ullon + lrlon) / 2.0, filename + "3");
        node.SE = insert(node, (ullat + lrlat) / 2.0, (ullon + lrlon) / 2.0, lrlat, lrlon, filename + "4");
        node.NW.East = node.NE;
        node.NW.South = node.SW;
        node.NE.South = node.SE;
        node.SW.East = node.SE;
        return node;
    }

    public ArrayList<QTreeNode> findBox(QTreeNode x, double ullat, double ullon, double lrlat, double lrlon, double queryDistancePerPixel) {
        if (ullon < -122.2998046875) {
            ullon = -122.2998046875;
        }
        if (lrlon > -122.2119140625) {
            lrlon = -122.2119140625;
        }
        int level = 0;
        double tileDPP = 0.00034332275390625;
        while (level <= MAX_DEPTH) {
            if (tileDPP <= queryDistancePerPixel) {
                break;
            }
            level += 1;
            tileDPP = tileDPP / 2;
        }
        if (level > MAX_DEPTH) {
            level = MAX_DEPTH;
        }
        x = this.root;
        while(x.getDepth() < level) {
            if (x.NW.contains(ullat, ullon)) {
                x = x.NW;
            } else if (x.NE.contains(ullat, ullon)) {
                x = x.NE;
            } else if (x.SW.contains(ullat, ullon)) {
                x = x.SW;
            } else if (x.SE.contains(ullat, ullon)) {
                x = x.SE;
            } else {
                break;
            }
        } 
        QTreeNode tempNode = x;
        ArrayList<QTreeNode> tempList = new ArrayList<>();
        //if (level == 0) {
            //ArrayList<QTreeNode> init = new ArrayList<>();
            //init.add(this.getRoot());
            //return init;
        //}
        while (tempNode != null) {
            if (tempNode.ULLAT > lrlat) {
                tempList.add(tempNode);
            } else {
                break;
            }
            tempNode = tempNode.South;
        }
        row = tempList.size();
        ArrayList<QTreeNode> list = new ArrayList<>();
        for (QTreeNode tile : tempList) {
            while (tile != null) {
                if (tile.getULLON() < lrlon) {
                    list.add(tile);
                } else {
                    break;
                }
                tile = tile.East;
            }
        }
        col = list.size() / row;
        return list;
    }
    public int getRow() {
        return this.row;
    }
    public int getCol() {
        return this.col;
    }

    public QTreeNode getRoot() {
        return this.root;
    }

    public class QTreeNode implements Comparable<QTreeNode>{
        private String fileName;
        private double ULLAT;
        private double ULLON;
        private double LRLAT;
        private double LRLON;
        private int depth;
        public QTreeNode parent;
        public QTreeNode NW; 
        public QTreeNode NE; 
        public QTreeNode SE; 
        public QTreeNode SW; 
        public QTreeNode East = null;
        public QTreeNode South = null;

        public QTreeNode(QTreeNode x, double ullat, double ullon, double lrlat, double lrlon, String filename) {
            this.ULLAT = ullat;
            this.ULLON = ullon;
            this.LRLAT = lrlat;
            this.LRLON = lrlon;
            this.parent = x;
            if (filename.equals("root")) {
                this.depth = 0;
            } else {
                this.depth = filename.length();
            }
            this.fileName = PREF + filename + SUF;
        }
        public boolean hasChild() {
            return this.getDepth() != MAX_DEPTH;
        }
        public boolean contains(double ullat, double ullon) {
            if (this.ULLON <= ullon && ullon < this.LRLON && this.ULLAT >= ullat && ullat > this.LRLAT) {
                return true;
            } else {
                return false;
            }
        }
        public String getFileName() {
            return this.fileName;
        }
        public int getDepth() {
            return this.depth;
        }
        public double getULLAT() {
            return ULLAT;
        }
        public double getULLON() {
            return this.ULLON;
        }
        public double getLRLAT() {
            return this.LRLAT;
        }
        public double getLRLON() {
            return this.LRLON;
        }
        public QTreeNode NW() {
            return this.NW;
        }
        public QTreeNode NE() {
            return this.NE;
        }
        public QTreeNode SW() {
            return this.SW;
        }
        public QTreeNode SE() {
            return this.SE;
        }
        public QTreeNode parent() {
            return this.parent;
        }
        public int compareTo(QTreeNode other) {
            return Double.compare(this.ULLAT, other.ULLAT);
        }
    }

}
