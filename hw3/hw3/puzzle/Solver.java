package hw3.puzzle;
import edu.princeton.cs.algs4.MinPQ;
import java.util.ArrayList;

public class Solver {
    private int moves;
    private MinPQ<SearchNode> gameTree;
    private ArrayList<WorldState> chosenPath;
    // private HashSet<Board> boardSaver;
    // private HashMap<Board, Integer> boardSaver;

    private class SearchNode implements Comparable<SearchNode> {
        // The input of priority queue
        private WorldState board;
        private int moves;
        private int priority;
        private SearchNode prevNode;
        
        public SearchNode(WorldState input, int i, SearchNode prev) {
            board = input;
            moves = i;
            prevNode = prev;
            priority = moves + board.estimatedDistanceToGoal();
        }
        public int priority() {
            return this.priority;
        }

        // Implement the compareTo method
        public int compareTo(SearchNode other) {
            return Integer.compare(this.priority(), other.priority());
        }
        public WorldState board() {
            return this.board;
        }
        public WorldState prevBoard() {
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
    // Constructor
    public Solver(WorldState initial) {
        // First, insert the initial search node (the initial board, 
        // 0 moves, and a null previous search node) into a priority queue.
        gameTree = new MinPQ<SearchNode>();
        chosenPath = new ArrayList<WorldState>();
        // Save the path
        chosenPath.add(0, initial);
        int moveCount = 0;
        SearchNode initialNode = new SearchNode(initial, moveCount, null);
        gameTree.insert(initialNode);
        int counter = 0;
        // Repeat until the search node dequeued corresponds to a goal board.
        while (!gameTree.min().board().isGoal()) {
            // Then, delete from the priority queue the search node with the minimum priority,
            int pri1 = gameTree.min().priority();

            SearchNode current = gameTree.delMin();
            WorldState currentBoard = current.board();
            WorldState prevBoard = current.prevBoard();
            for (WorldState x : currentBoard.neighbors()) {
                if (!x.equals(prevBoard)) {
                    SearchNode newNode = new SearchNode(x, current.moves() + 1, current);
                    gameTree.insert(newNode);
                } else {
                    counter++;
                }
            }
        }
        // System.out.println(counter);
        // Traverse back to get the path
        SearchNode end = gameTree.min();
        while (end.prevBoard() != null) {
            chosenPath.add(1, end.board());
            end = end.prevNode();
        }
    }
    public int moves() {
        // Return the minimum number of moves to solve the initial board
        return chosenPath.size() - 1;
    }

    public Iterable<WorldState> solution() {
        // Return the sequence of Boards from the initial board to the solution
        // Use the node to traverse back to its parent
        return this.chosenPath;
    }

}
