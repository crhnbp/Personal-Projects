public class Percolation {
    private int top;
    private int bottom;
    private int x;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF uf1;
    private byte[] site; 

    public Percolation(int N) {
        x = N;
        uf = new WeightedQuickUnionUF(x * x + 2);
        uf1 = new WeightedQuickUnionUF(x * x + 2);
        top = x * x;
        bottom = x * x + 1;
        site = new byte[x * x];
    }

    private int 2dto1d(int i, int j) {
        int pos = x * (i - 1) + j - 1;
        return pos;
    }
    
    public void open(int i, int j) {
        inBounds(i, j);
        if (isOpen(i, j)) {
            return;
        } else {
        int currentSite = 2dto1d(i, j); 
        this.site[currentSite] = 1;
        }

        if (i == 1 && !uf.connected(currentSite, top)) {
            uf.union(currentSite, top);
            uf1.union(currentSite, top);
        }
        
        if (i == n) {
            uf1.union(currentSite, bottom);
        }
        
        if (i > 1) {
            if (isOpen(i - 1, j)) {
                uf.union(currentSite, 2dto1d(i-1, j));
                uf1.union(currentSite, 2dto1d(i-1, j));
            }
        }
        
        if (i < n) {
            if (isOpen(i + 1, j)) {
                uf.union(currentSite, 2dto1d(i + 1, j));
                uf1.union(currentSite, 2dto1d(i + 1, j));
            }
        }

        if (j > 1) {
            if (isOpen(i, j - 1)) {
                uf.union(currentSite, 2dto1d(i, j - 1));
                uf1.union(currentSite, 2dto1d(i, j - 1));
            }
        }
        
        if (j < n) {
            if (isOpen(i, j + 1)) {
                uf.union(currentSite, 2dto1d(i, j + 1));
                uf1.union(currentSite, 2dto1d(i, j + 1));
            }
        }
    }
    
    private boolean inBounds(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n) {
            throw new IndexOutOfBoundsException();
        } else {
        return true;
    }
}

    public boolean isOpen(int i, int j)    {
        inBounds(i, j);
        if (site[2dto1d(i, j)] == 1){
            return true;
        }
        return false;
    }
    
    public boolean isFull(int i, int j)    
    {
        inBounds(i, j);
        if (!isOpen(i, j)) {
            return false;
        }
        int currentSite = 2dto1d(i, j);
        if (uf.connected(top, currentSite)) {
            return true;
        }
        return false;
    }
    
    public boolean percolates()            
    {
        if (uf1.connected(top, bottom)) {
            return true;
        }
        return false;
    }
}