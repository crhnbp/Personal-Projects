import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;

public class ArrayHeap<T> implements ExtrinsicPQ<T>{
    private ArrayList<Node> contents = new ArrayList<Node>();
    private static int size = 0;

    public ArrayHeap() {
        contents.add(0, null);
    }

    public boolean isEmpty() {
        return getNode(1) == null;
    }

    public void insert(T item, double priority) {
        size += 1;
        Node temp = new Node(item, priority);
        setNode(size , temp);
        swim(size);
        assert isArrayHeap();
    }
    
    private boolean isArrayHeap() {
        return isArrayHeap(1);
    }
    private boolean isArrayHeap(int index) {
        if (index > contents.size()) {
            return true;
        }
        int left = index * 2;
        int right = index * 2 + 1;
        if (left <= contents.size() && min(index, left) == left) {
            return false;
        }
        if (right <= contents.size() && min(index, right) == right) {
            return false;
        }
        return isArrayHeap(left) && isArrayHeap(right);
    }

    public Node peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return getNode(1);
    }

    public Node removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        Node min = getNode(1);
        setNode(1, null);
        swap(1, size);
        sink(1);
        // contents.get(size) = null;
        size -= 1;
        assert isArrayHeap();
        return min;
    }

    private void validateSinkSwimArg(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Cannot sink or swim nodes with index 0 or less");
        }
        if (index > size) {
            throw new IllegalArgumentException("Cannot sink or swim nodes with index greater than current size.");
        }
        if (contents[index] == null) {
            throw new IllegalArgumentException("Cannot sink or swim a null node.");
        }
    }

    public void changePriority(T item, double priority) {
        ArrayHeap temp = new ArrayHeap();
        for (Node x : contents) {
            if (x.item().equals(item)) {
                x = new Node(item, priority);
            }
            temp.insert(this.removeMin().item(), this.removeMin().priority());
        }
        this.contents = temp.contents;
    }

    @Override
    public String toString() {
        return toStringHelper(1, "");
    }

    private String toStringHelper(int index, String soFar) {
        if (getNode(index) == null) {
            return "";
        } else {
            String toReturn = "";
            int rightC = rightIndex(index);
            toReturn += toStringHelper(rightC, "        " + soFar);
            if (getNode(rightC) != null) {
                toReturn += soFar + "    /";
            }
            toReturn += "\n" + soFar + getNode(index) + "\n";
            int leftC = leftIndex(index);
            if (getNode(leftC) != null) {
                toReturn += soFar + "    \\";
            }
            toReturn += toStringHelper(leftC, "        " + soFar);
            return toReturn;
        }
    }

    private Node getNode(int index) {
        if (index >= contents.size()) {
            return null;
        } else {
            return contents.get(index);
        }
    }

    private void setNode(int index, Node n) {
        while (index + 1 >= contents.size()) {
            contents.add(null);
        }
        contents.set(index, n);
    }

    private void swap(int index1, int index2) {
        Node node1 = getNode(index1);
        Node node2 = getNode(index2);
        this.contents.set(index1, node2);
        this.contents.set(index2, node1);
    }

    private int leftIndex(int i) {
        int x = 2 * i;
        if (x < 1) {
            return 0;
        } else {
            return x;
        }
    }

    private int rightIndex(int i) {
        int x = 2 * i + 1;
        if (x > contents.size()) {
            // throw new IndexOutOfBoundsException();
            return 0;
        } else {
            return x;
        }
    }

    private int parentIndex(int i) {
        int x = i / 2;
        if (x < 1) {
            // throw new IndexOutOfBoundsException();
            return 1;
        } else {
            return x;
        }
    }

    private void setLeft(int index, Node n) {
        int pos = index * 2;
        setNode(pos, n);
    }

    private void setRight(int index, Node n) {
        int pos = index * 2 + 1;
        setNode(pos, n);
    }

    private void swim(int index) {
        while (index > 1 && higherP(parentIndex(index), index)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void sink(int index) {
        while (leftIndex(index) <= size) {
            int j = leftIndex(index);
            if (j != 0 && j < size && higherP(j, rightIndex(index))) {
                j += 1;
            }
            if (higherP(j, index)) {
                break;
            }
            swap(index, j);
            index = j;
        }
    }

    private boolean higherP(int index1, int index2) {
        return min(index1, index2) == index2;
    }

    private int min(int index1, int index2) {
        Node node1 = getNode(index1);
        Node node2 = getNode(index2);
        if (node1 == null) {
            return index2;
        } else if (node2 == null) {
            return index1;
        } else if (node1.myPriority < node2.myPriority) {
            return index1;
        } else {
            return index2;
        }
    }

    public class Node {
        private T theItem;
        private double thePriority;

        private Node(T item, double priority) {
            theItem = item;
            thePriority = priority;
        }

        public T item() {
            return theItem;
        }

        public double priority() {
            return thePriority;
        }

        @Override
        public String toString() {
            return item().toString() + ", " + priority();
        }
    }

}
