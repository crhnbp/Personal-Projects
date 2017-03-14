package hw2;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int top = 0;
    private int bottom;
    private int size;
    private WeightedQuickUnionUF uf;
    private boolean[][] opened;
    private int numopen;

    public Percolation(int N) {
        size = N;
        opened = new boolean[size][size];
        bottom = size * size + 1;
        uf = new WeightedQuickUnionUF(size * size + 2);
    }

    public int numOpen() {
        return numopen;
    }
    public void open(int i, int j) {
        opened[i - 1][j - 1] = true;
        numopen = numopen + 1;
        if (i == 1) {
            uf.union(getInd(i, j), top);
        }
        if (i == size) {
            uf.union(getInd(i, j), bottom);
        }
        if (j > 1 && isOpen(i, j - 1)) {
            uf.union(getInd(i, j), getInd(i, j - 1));
        }
        if (j < size && isOpen(i, j + 1)) {
            uf.union(getInd(i, j), getInd(i, j + 1));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            uf.union(getInd(i, j), getInd(i - 1, j));
        }
        if (i < size && isOpen(i + 1, j)) {
            uf.union(getInd(i, j), getInd(i + 1, j));
        }
    }

    public boolean isOpen(int i, int j) {
        return opened[i - 1][j - 1];
    }

    public boolean isFull(int i, int j) {
        if (0 < i && i <= size && 0 < j && j <= size) {
            return uf.connected(top, getInd(i , j));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean percolates() {
        return uf.connected(top, bottom);
    }

    private int getInd(int i, int j) {
        return size * (i - 1) + j;
    }
}
