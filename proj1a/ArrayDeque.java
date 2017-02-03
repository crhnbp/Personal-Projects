public class ArrayDeque<Item> {

    private int size;
    private Item item;
    private int nextLast;
    private int nextFirst;
    private Item[] items;
    private static int FACTOR = 4;

    public ArrayDeque() {
        size = 0;
        nextFirst = 0;
        items = (Item []) new Object[8];
        nextLast = size;
    }

    private void resize(int cap) {
        Item[] a = (Item []) new Object[cap];
        if (nextFirst < nextLast) {
            System.arraycopy(items, 0, a, 0, size);
        } else {
            System.arraycopy(items, nextFirst, a, 0, size - nextFirst);
            System.arraycopy(items, 0, a, size - nextFirst, nextFirst);
        }
        nextFirst = 0;
        nextLast = size - 1;
        items = a;
    }


    public void addFirst(Item x) {
        if (size == 0) {
            size += 1;
            items[nextFirst] = x;
        } else {
            if (size >= items.length) {
                resize(size * FACTOR);
                nextFirst = items.length - 1;
            } else {
                if (nextFirst == 0) {
                    nextFirst = items.length - 1;
                } else if (nextFirst <= nextLast) {
                    nextFirst -= 1;
                } else {
                    nextFirst -= 1;
                }
            }
            items[nextFirst] = x;
            size += 1;
        }
    }


    public void addLast(Item x) {
        if (size >= items.length) {
            resize(size * FACTOR);
            nextLast += 1;
            items[nextLast] = x;
        } else if (size == 0) {
            items[nextLast] = x;
        } else {
            if (nextLast == items.length - 1) {
                nextLast = 0;
            } else {
                nextLast += 1;
            }
            items[nextLast] = x;
        }
        size += 1;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Item get(int index) {
        if (size == 0) {
            return null;
        } else if (index == 0) {
            return items[nextFirst];
        } else if (nextLast < nextFirst) {
            if (index < items.length - nextFirst) {
                return items[index + nextFirst];
            } else {
                return items[index - (items.length - nextFirst)];
            }
        } else {
            return items[index + nextFirst];
        }
    }


    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        Item tempo = items[nextFirst];
        items[nextFirst] = null;
        if ((nextFirst < nextLast) || ((nextFirst > nextLast) && (nextFirst != items.length - 1))) {
            nextFirst += 1;
        } else if (nextFirst == nextLast) {
            nextFirst = nextFirst;
        } else if (nextFirst == items.length - 1) {
            nextFirst = 0;
        }
        size -= 1;
        return tempo;
    }


    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        Item tempo = items[nextLast];
        items[nextLast] = null;
        if (size != 1) {
            if (nextLast == 0) {
                nextLast = items.length - 1;
            } else {
                nextLast -= 1;
            }
        }
        size -= 1;
        return tempo;
    }

    public void printDeque() {
        if (size == 0) {
            return;
        }
        if (nextLast < nextFirst) {
            for (int i = nextFirst; i <= items.length - 1; i++) {
                System.out.print(items[i] + " ");
            }
            for (int j = 0; j <= nextLast; j++) {
                System.out.print(items[j] + " ");
            }
        } else {
            for (int k = nextFirst; k <= nextLast; k++) {
                System.out.print(items[k] + " ");
            }
        }
    }

}


    