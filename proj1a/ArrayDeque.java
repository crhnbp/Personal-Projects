public class ArrayDeque<Item>{
    private static double ratio = 0.25;
    private static int HEHEXD = 2;
    private int size;
    private int nextFirst;
    private int nextLast;
    private Item[] stuff;
    
    
    public ArrayDeque(){
        size = 0;
        nextFirst = 4;
        nextLast = 5;
        stuff = (Item[]) new Object[8];
    }
    
    private void resize(int cap){
        Item[] a = (Item[]) new Object[cap];
        int start = (cap - size) / 2;
        if (nextFirst < nextLast){
            int i = nextFirst + 1;
            while(i < nextLast){
                a[start] = stuff[i];
                i += 1;
            }
        }
        else{
            int i = nextFirst + 1; 
            while(i < stuff.length){
                a[start] = stuff[i];
                i += 1;
            }
            int x = 0;
            while(x < nextLast){
                a[start + stuff.length - nextFirst] = stuff[x];
                x += 1;
            }
        }
        nextFirst = start - 1;
        stuff = a;
        nextLast = nextFirst + size + 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    
    public int size(){
        return size;
    }

    public Item get(int index){
        return stuff[(index+nextFirst+1)% items.length];
    }
    
    public void addFirst(Item x){
        size += 1;
        if (size >= stuff.length - 2){
            resize(size * HEHEXD);
        }
        stuff[nextFirst] = x;
        if (nextFirst == 0){
            nextFirst = stuff.length - 1;
        } else {
            nextFirst = nextFirst - 1;
        }       
    }
    
    public void addLast(Item x){
        size += 1;
        if (size >= stuff.length - 2){
            resize(size * HEHEXD);
        }
        stuff[nextLast] = x;
        if (nextLast == stuff.length - 1){
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }
    
    
    public void printDeque(){
        if (nextFirst < nextLast){
            int i = nextFirst + 1;
            while (i < nextLast){
                System.out.print(stuff[i]);
                System.out.print(' ');
                i += 1;
            }
        }
        else{
            int i = nextFirst + 1;
            while(i < stuff.length){
                System.out.print(stuff[i]);
                System.out.print(' ');
                i += 1;
            }
            int j = 0;
            while(j < nextLast){
                System.out.print(stuff[j]);
                System.out.print(' ');
                j += 1;
            }
        }
        System.out.println();
    }
    
    public Item removeFirst(){
        if (size == 0){
            return null;
        }
        if (stuff.length >= 16 && (double)size / stuff.length <= ratio){
            resize(size * HEHEXD);
        }
        Item hehe;
        if (nextFirst == stuff.length - 1){
            hehe = stuff[0];
            nextFirst = 0;  
        } else {
            hehe = stuff[nextFirst + 1];
            nextFirst += 1;
        }
        stuff[nextFirst] = null;
        size -= 1;
        return hehe;
    }
    
    public Item removeLast(){
        if (size == 0){
            return null;
        }
        if (stuff.length >= 16 && (double)size / stuff.length <= ratio){
            resize(size * HEHEXD);
        }
        Item hehe;
        if (nextLast == 0){
            hehe = stuff[stuff.length - 1];
            nextLast = stuff.length - 1;
        }
        else{
            hehe = stuff[nextLast - 1];
            nextLast -= 1;
        }
        stuff[nextLast] = null;
        size -= 1;
        return hehe;
    }
    
    
}
