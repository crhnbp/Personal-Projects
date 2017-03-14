package hw2;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class Percolation {
    private int top;
    private int bottom;
    private int x;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF uf1;
    private byte[] site; 
    private int opens;

    public Percolation(int N) {
        x = N;
        uf = new WeightedQuickUnionUF(x * x + 2);
        uf1 = new WeightedQuickUnionUF(x * x + 2);
        top = x * x;
        bottom = x * x + 1;
        site = new byte[x * x];
    }

    private int getInd(int i, int j) {
        int pos = x * (i - 1) + j - 1;
        return pos;
    }

    private int numberOfOpenSites() {
        return opens;
    }
    
    public void open(int i, int j) {
        inBounds(i, j);
        int currentSite = getInd(i, j); 
        if (isOpen(i, j)) {
            return;
        } else {
        this.site[currentSite] = 1;
        opens = opens + 1;
        }

        if (i == 1 && !uf.connected(currentSite, top)) {
            uf.union(currentSite, top);
            uf1.union(currentSite, top);
        }
        
        if (i == x) {
            uf1.union(currentSite, bottom);
        }
        
        if (i > 1) {
            if (isOpen(i - 1, j)) {
                uf.union(currentSite, getInd(i-1, j));
                uf1.union(currentSite, getInd(i-1, j));
            }
        }
        
        if (i < x) {
            if (isOpen(i + 1, j)) {
                uf.union(currentSite, getInd(i + 1, j));
                uf1.union(currentSite, getInd(i + 1, j));
            }
        }

        if (j > 1) {
            if (isOpen(i, j - 1)) {
                uf.union(currentSite, getInd(i, j - 1));
                uf1.union(currentSite, getInd(i, j - 1));
            }
        }
        
        if (j < x) {
            if (isOpen(i, j + 1)) {
                uf.union(currentSite, getInd(i, j + 1));
                uf1.union(currentSite, getInd(i, j + 1));
            }
        }
    }
    
    private boolean inBounds(int i, int j) {
        if (i < 1 || i > x || j < 1 || j > x) {
            throw new IndexOutOfBoundsException();
        } else {
        return true;
    }
}

    public boolean isOpen(int i, int j) {
        inBounds(i, j);
        if (site[getInd(i, j)] == 1){
            return true;
        }
        return false;
    }
    
    public boolean isFull(int i, int j) {
        inBounds(i, j);
        if (!isOpen(i, j)) {
            return false;
        }
        int currentSite = getInd(i, j);
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