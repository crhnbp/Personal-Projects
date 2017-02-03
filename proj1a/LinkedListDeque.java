public class LinkedListDeque<Item> {

    private class Node {
        private Item stuff;
        private Node prev;
        private Node next;
        
        private Node(Item x, Node y, Node z) {
            stuff = x;
            prev = y;
            next = z;
        }
        private Node() {
            this.stuff = null;
            this.prev = this;
            this.next = this;
        }
        
    }
    private Node sentinel;
    private int size;
    
    public LinkedListDeque() {
        sentinel = new Node();
        size = 0;
    }
    
    public void addFirst(Item stuff) {
        size += 1;
        Node n = new Node(stuff, sentinel, sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;
    }
    
    public void addLast(Item stuff) {
        size += 1;
        Node n = new Node(stuff, sentinel.prev, sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    public Item get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node xd = sentinel.next;
        for (int i = 0; i < index; i++) {
            xd = xd.next;
        }
        return xd.stuff;
    }
    
    public Item getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return helper(index, sentinel.next);
    }

    
    public void printDeque() {
        Node xd = sentinel;
        while (xd.next != sentinel) {
            System.out.print(xd.stuff);
            System.out.print(' ');
            xd = xd.next;
        }
        System.out.println();
    }
    
    public Item removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        } else {
            Node n = sentinel.next;
            n.next.prev = sentinel;
            sentinel.next = n.next;
            size -= 1;
            return n.stuff;
        }
    }
    
    public Item removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        } else {
            Node n = sentinel.prev;
            n.prev.next = sentinel;
            sentinel.prev = n.prev;
            size -= 1;
            return n.stuff;
        }
    }
    private Item helper(int n, Node xd) {
        if (n == 0) {
            return xd.stuff;
        }
        return helper(n - 1, xd.next);
    }
}

