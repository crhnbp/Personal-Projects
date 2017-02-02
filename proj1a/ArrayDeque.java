public class ArrayDeque<Item> {
    private int size;
    private Item item;
    private int nextLast;
    private int nextFirst;
    private Item[] array;

    public ArrayDeque() {
        size = 0;
        nextFirst = 0;
        array = (Item []) new Object[8];
        nextLast = size;
    }

    private void resize(int cap) {
        Item[] a = (Item []) new Object[cap];
        if (nextFirst < nextLast) {
            System.arraycopy(array, 0, a, 0, size);
        } else {
            System.arraycopy(array, nextFirst, a, 0, size - nextFirst);
            System.arraycopy(array, 0, a, size - nextFirst, nextFirst);
        }
        array = a;
        nextFirst = 0;
        nextLast = size - 1;
    }


    public void addFirst(Item x) {
        if(size == 0){
            size += 1;
            array[nextFirst] = x;
        } else {
            if(size >= array.length) {
                resize(size * 4);
                nextFirst = array.length - 1;
            } else {
                if(nextFirst == 0) {
                    nextFirst = array.length - 1;
                } else if(nextFirst <= nextLast) {
                    nextFirst -= 1;
                } else {
                    nextFirst -= 1;
                }
            }
            array[nextFirst] = x;
            size += 1;
        }
    }


    public void addLast(Item x) {
        if(size >= array.length){
            resize(size * 4);
            nextLast += 1;
            array[nextLast] = x;
        } else if(size == 0){
            array[nextLast] = x;
        } else {
            if(nextLast == array.length - 1){
                nextLast = 0;
            } else {
                nextLast += 1;
            }
            array[nextLast] = x;
        }
        size += 1;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

    public Item get(int index) {
        if (size == 0) {
            return null;
        } else if (index == 0) {
            return array[nextFirst];
        } else if (nextLast < nextFirst) {
            if (index < array.length - nextFirst) {
                return array[index + nextFirst];
            } else {
                return array[index - (array.length - nextFirst)];
            }
        } else {
            return array[index + nextFirst];
        }
    }



    public void printDeque() {
        if (size == 0) {
            return;
        }
        if (nextLast < nextFirst) {
            for (int i = nextFirst; i <= array.length - 1; i++) {
                System.out.print(array[i] + " ");
            }
            for (int j = 0; j <= nextLast; j++) {
                System.out.print(array[j] + " ");
            }
        } else {
            for (int k = nextFirst; k <= nextLast; k++) {
                System.out.print(array[k] + " ");
            }
        }
    }


    public Item removeFirst(){
        if(size == 0){
            return null;
        }
        Item Temp = array[nextFirst];
        array[nextFirst] = null;
        if((nextFirst < nextLast) || ((nextFirst > nextLast) && (nextFirst != array.length - 1))) {
            nextFirst += 1;
        } else if(nextFirst == nextLast){
            nextFirst = nextFirst;
        } else if(nextFirst == array.length - 1) {
            nextFirst = 0;
        }
        size -= 1;
        return Temp;
    }


    public Item removeLast(){
        if(size == 0){
            return null;
        }
        Item Temp = array[nextLast];
        array[nextLast] = null;
        if(size != 1){
            if(nextLast == 0){
                nextLast = array.length - 1;
            } else {
                nextLast -= 1;
            }
        }
        size -= 1;
        return Temp;
    }
}

    