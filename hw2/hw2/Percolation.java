package hw2;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int rowSize;
    private int gridSize;
    private boolean[] grid;
    private WeightedQuickUnionUF unionFind;
    private int bottomVS;
    private int topVS;
    private int numopen;

    
    public Percolation(int number) {
        if (number <= 0) {
            throw new java.lang.IllegalArgumentException(
                    "N must be larger than 0");
        }
        rowSize    = number;
        gridSize   = number * number;
        grid       = new boolean[gridSize];
        bottomVS   = gridSize + 1;
        topVS      = gridSize;
        unionFind  = new WeightedQuickUnionUF(gridSize + 2);

    }

    private void checkIndex(int i, int j) {

        if (i < 1 || i > rowSize) {
            throw new java.lang.IndexOutOfBoundsException(
                    "i must be between 1 and " + rowSize);
        }
        if (j < 1 || j > rowSize) {
            throw new java.lang.IndexOutOfBoundsException(
                    "j must be between 1 and " + rowSize);
        }
    }

    private int changeDimension(int i, int  j) {
        // 2D coordinates to right index on 1D array.
        // ( row -1 x column ) + row -1
        int newIndex = (i - 1) * rowSize + (j - 1);
        return newIndex;
    }

    public int numberOfOpenSsites() {
        return numopen;
    }

    public void open(int i, int j) {
        checkIndex(i, j);
        int index = changeDimension(i, j);
        grid[index] = true;
        numopen = numopen + 1;

        if (i == 1) {
            unionFind.union(index, topVS);
        }

        boolean hasN = false;
        for (int k = 0; k < 4; k++) {
            int adjacent = getAdjacentIndex(i, j, k);
            if (adjacent != -1) {
                unionFind.union(adjacent, index);
                hasN = true;
            }
        }

        if (hasN) {
            for (int index2 = gridSize - 1; index2 >= gridSize - rowSize;
                    index2--) {
                if (grid[index2] && unionFind.connected(topVS, index2)) {
                    unionFind.union(index2, bottomVS);
                    break;
                   }
            }
        }

    }

    private int getAdjacentIndex(int i, int j, int k) {

        int row = 0, column = 0, adjacent = -1;

        if (k == 0) {  //up
            row = i - 1;
            column = j;
        } else if (k == 1) { //down
            row = i + 1;
            column = j;
        } else if (k == 2) { //left
            row = i;
            column = j - 1;
        } else if (k == 3) {
            row = i;
            column = j + 1;
        } else {
            throw new java.lang.IllegalArgumentException(
                    "Direction must be between 0 and 3");
        }

        if (row > 0 && row <= rowSize && column > 0
                && column <= rowSize) {
            if (isOpen(row, column)) {
                adjacent = changeDimension(row, column);
            }
        }

        return adjacent;
    }

    public boolean isOpen(int i, int j) {
        checkIndex(i, j);
        boolean isItOpen = grid[changeDimension(i, j)];
        return isItOpen;

    }

    public boolean isFull(int i, int j) {
        checkIndex(i, j);
        boolean isItFull = unionFind.connected(
                topVS, changeDimension(i, j));
        return isItFull;

    }

    public boolean percolates() {
        boolean doesIt = unionFind.connected(topVS, bottomVS);
        return doesIt;
    }


    public static void main(final String[] args) {

        Percolation p = new Percolation(4);
        System.out.println("Bottom virtual site position "
                + p.bottomVS);
        System.out.println("Does it percolates? " + p.percolates());
        System.out.println("Grid lenght " + p.grid.length);
         p.open(4, 1);
         p.open(3, 1);
         p.open(2, 1);
         p.open(1, 1);
         p.open(1, 4);
         p.open(2, 4);
         System.out.println(p.unionFind.connected(16, 8));
         p.open(4, 4);
         System.out.println(p.unionFind.find(3));
        System.out.println("Does it percolates? " + p.percolates());

    }


}
