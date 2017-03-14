package hw2;                       
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.Arrays;

public class Percolation {
    
    private boolean[][] grid;
    private int gridSize;
    private int gridDark;
    private int numberOfOpenSites;
    private boolean percolate;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF uf1;
    
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException(N + " is not positive");
        }
        numberOfOpenSites = 0;
        gridSize = N * N;
        gridDark = N;
        grid = new boolean[gridDark][gridDark]; 
        for (boolean[] row : grid) {
            Arrays.fill(row, false);
        }
        percolate = false;
        uf = new WeightedQuickUnionUF(gridSize + 2);
        uf1 = new WeightedQuickUnionUF(gridSize + 1);

    }

    private int getInd(int row, int col) {
        int index = col + 1;
        if (row > 0) {
            index = row * gridDark + col + 1;
        }
        return index;
    }
    
    private void inBounds(int row, int col) {
        if (row < 0 || row >= gridDark || col >= gridDark || col < 0) {
            throw new IndexOutOfBoundsException();
        }
        int x = getInd(row, col);
        if (x < 1 || x >  gridSize) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    public void open(int row, int col) {
        try {
            inBounds(row, col);
            int index = getInd(row, col);
            if (!isOpen(row, col)) {
                grid[row][col] = true;
                numberOfOpenSites += 1;
                if (row - 1 >= 0) {
                    if (isOpen(row - 1, col)) {
                        uf.union(index, getInd(row - 1, col));
                        uf1.union(index, getInd(row - 1, col));
                    }
                }
                if (row + 1 < gridDark) {
                    if (isOpen(row + 1, col)) {
                        uf.union(index, getInd(row + 1, col));
                        uf1.union(index, getInd(row + 1, col));
                    }
                }
                if (col - 1 >= 0) {
                    if (isOpen(row, col - 1)) {
                        uf.union(index, getInd(row, col - 1));
                        uf1.union(index, getInd(row, col - 1));
                    }
                }
                if (col + 1 < gridDark) {
                    if (isOpen(row, col + 1)) {
                        uf.union(index, getInd(row, col + 1));
                        uf1.union(index, getInd(row, col + 1));
                    }
                }
                if (row == 0) {
                    uf.union(index, 0);
                    uf1.union(index, 0);
                }
                if (row == gridDark - 1) {
                    uf.union(index, gridSize + 1);
                }
                if (row == gridDark - 1) {
                    if (isFull(row, col)) {
                        percolate = true;
                    }
                }
                if (uf.connected(0, gridSize + 1)) {
                    percolate = true;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            //xd
        }
    }
    
    public boolean isOpen(int row, int col) {
        try {
            inBounds(row, col);
            int index = getInd(row, col);
            return grid[row][col];
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
    
    public boolean isFull(int row, int col) {
        try {
            inBounds(row, col);
            int index = getInd(row, col);
            return uf1.connected(index, 0);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
    
    public boolean percolates() {
        return percolate;
    }
    
    public static void main(String[] args) {
    }
}       
