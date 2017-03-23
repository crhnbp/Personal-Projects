package hw3.puzzle;

// import java.lang.IndexOutOfBoundsException;
// import java.util.Arrays;

public class Board {
    
    private final int[][] board;
    private int size;
    private int hamming;
    private int manhattan = -1;

    public Board(int[][] tiles) {
        int[][] temp = tiles;
        size = tiles.length;
        board = new int[size][size];
        for (int i = 0; i < size; i += 1) {
            for (int j = 0; j < size; j += 1) {
                board[i][j] = temp[i][j];
            }
        }
        int ham = 0;
        for (int i = 0; i < size; i += 1) {
            for (int j = 0; j < size; j += 1) {
                if (tileAt(i, j) != i * size + j + 1) {
                    ham += 1;
                }
            }
        }
        hamming = ham;
        int man = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int now = tileAt(i, j);
                if (now != 0) {
                    int row = (now - 1) / size;
                    int col = (now - 1) % size;
                    man += Math.abs(i - row) + Math.abs(j - col);
                }
            }
        }
        manhattan = man;
    }
    
    @Override
    public int hashCode() {
        int hash = java.util.Arrays.deepHashCode(this.board());
        return hash;
    }
    
    public int[][] board() {
        return this.board;
    }
    
    public int tileAt(int i, int j) {
        if (i < 0 || i > size || j < 0 || j > size) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        if (board == null) {
            return 0;
        } else {
            return this.board[i][j];
        }
    }

    public int size() {
        return size;
    }
    public int hamming() {
        return this.hamming;
    }
    public int manhattan() {
        return this.manhattan;
    }
    public boolean isGoal() {
        if (this == null) {
            return false;
        }
        return this.manhattan == 0;
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() == object.getClass()) {
            for (int i = 0; i < size; i += 1) {
                for (int j = 0; j < size; j += 1) {
                    Board obj = (Board) object;
                    if (this.tileAt(i, j) != obj.tileAt(i, j)) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i += 1) {
            for (int j = 0; j < N; j += 1) {
                s.append(String.format("%2d ", tileAt(i, j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}