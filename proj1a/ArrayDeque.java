public class ArrayDeque<Item> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private Item[] items;

    public ArrayDeque() {
    int size = 0;
    items = (Item[]) new Object[8];
    int nextFirst = 0;
    int nextLast = size;
    }

    private Item[] resize(Item[] items, boolean bool) {
    if (bool == true) {
        Item[] newItems = (Item[]) new Object[2*items.length];
        System.arraycopy(items,0,newItems,0,items.length);
        return newItems;
    }
    if (bool == false) {
        Item[] newItems = (Item[]) new Object[items.length/2];
        System.arraycopy(items,0,newItems,0,items.length);
        return newItems;
    }
    return null;
    }

    private void bigger(Item[] items) {
    size = size + 1;
    if (size == items.length) {
        boolean bool = true;
        items = resize(items, bool);
    }
    }

    private void smaller(Item[] items) {
    size = size - 1;
    if (size <= items.length/4) {
        if (size <= 2) {
        return;
        }
        boolean bool = false;
        items = resize(items, bool);
    }
    }

    public void addFirst(Item x) {
    bigger(items);
    items[nextFirst] = x;
    if (nextFirst == 0) {
        nextFirst = items.length;
    }
    else {
    nextFirst = nextFirst - 1;
    }
    }

    public void addLast(Item x) {
        bigger(items);
    items[nextLast] = x;
    if (nextLast == items.length) {
        nextLast = 0;
    }
    else {
        nextLast = nextLast + 1;
    }
    }

    public Item removeFirst() {
    smaller(items);
    if (nextFirst == items.length) {
        nextFirst = 0;
    }
    else {
        nextFirst = nextFirst + 1;
    }
    Item oldFirst = items[nextFirst];
    items[nextFirst] = null;
    return oldFirst;
    }

    public Item removeLast() {
    smaller(items);
    if (nextLast == 0) {
        nextLast = items.length;
    }
    else {
        nextLast = nextLast - 1;
    }
    Item oldLast = items[nextLast];
    items[nextLast] = null;
    return oldLast;
    }

    public Item get(int index) {
    return items[index];
    }

    public boolean isEmpty() {
    if (size == 0) {
        return true;
    }
    return false;
    }

    public int size() {
    return size;
    }

    public void printDeque() {
    int index;
    if (nextFirst == items.length) {
        index = 0;
    }
    else {
        for (index = nextFirst + 1;index <= nextLast - 1;index += 1) {
        System.out.print(items[index]);
        System.out.print(" ");
        }
    }
    }
        
        
}