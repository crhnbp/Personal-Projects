package hw3.puzzle;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MinPQ;
import java.util.ArrayList;

public class Solver {
    
    private int moves;
    private MinPQ<SearchNode> gameTree;
    private ArrayList<WorldState> chosenPath;
    // private HashSet<Board> boardSaver;
    // private HashMap<Board, Integer> boardSaver;

    private class SearchNode implements Comparable<SearchNode> {
        private Board board;
        private int moves;
        private int priority;
        private SearchNode prevNode;
        
        public SearchNode(WorldState input, int i, SearchNode prev) {
            board = input;
            moves = i;
            prevNode = prev;
            priority = moves + board.manhattan();
        }
        public int priority() {
            return this.priority;
        }

        public int compareTo(SearchNode other) {
            return Integer.compare(this.priority(), other.priority());
        }
        public Board board() {
            return this.board;
        }
        public Board prevBoard() {
            if (prevNode == null) {
                return null;
            } else {
                return this.prevNode.board();
            }
        }
        public SearchNode prevNode() {
            return prevNode;
        }
        public int moves() {
            return this.moves;
        }
        public ArrayList<WorldState> chosenPath() {
            return chosenPath;
        }
    }

    public Solver(WorldState initial) {
        gameTree = new MinPQ<SearchNode>();
        chosenPath = new ArrayList<WorldState>();
        chosenPath.add(0, initial);
        int moveCount = 0;
        SearchNode initialNode = new SearchNode(initial, moveCount, null);
        gameTree.insert(initialNode);
        int counter = 0;
        while (!gameTree.min().board().isGoal()) {
            int pri1 = gameTree.min().priority();

            SearchNode current = gameTree.delMin();
            Board currentBoard = current.board();
            Board prevBoard = current.prevBoard();
            for (Board x : BoardUtils.neighbors(currentBoard)) {
                if (!x.equals(prevBoard)) {
                    SearchNode newNode = new SearchNode(x, current.moves() + 1, current);
                    gameTree.insert(newNode);
                } else {
                    counter += 1;
                }
            }
        }
        // System.out.println(counter);
        SearchNode end = gameTree.min();
        while (end.prevBoard() != null) {
            chosenPath.add(1, end.board());
            end = end.prevNode();
        }
    }
    public int moves() {
        return chosenPath.size() - 1;
    }

    public Iterable<WorldState> solution() {
        return this.chosenPath;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        WorldState initial = new Board(tiles);
        Solver solver = new Solver(initial);
        StdOut.println("Minimum number of moves = " + solver.moves());
        for (Board board : solver.solution()) {
            // System.out.println("printing the solution");
            StdOut.println(board);
        }
    }
}