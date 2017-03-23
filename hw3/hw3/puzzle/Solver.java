package hw3.puzzle;
import edu.princeton.cs.algs4.MinPQ;
import java.util.ArrayList;

public class Solver {
    
    private int moves;
    private MinPQ<SearchNode> gameTree;
    private ArrayList<WorldState> chosenPath;

    private class SearchNode implements Comparable<SearchNode> {
        private WorldState board;
        private SearchNode prevNode;
        private int moves;
        private int priority;
        
        SearchNode(WorldState input, int i, SearchNode prev) {
            board = input;
            moves = i;
            prevNode = prev;
            priority = moves + board.estimatedDistanceToGoal();
        }
        public int priority() {
            return this.priority;
        }

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
        chosenPath = new ArrayList<WorldState>();
        gameTree = new MinPQ<SearchNode>();
        chosenPath.add(0, initial);
        int moveCount = 0;
        SearchNode initialNode = new SearchNode(initial, moveCount, null);
        gameTree.insert(initialNode);
        int count = 0;
        while (!gameTree.min().board().isGoal()) {
            int pre = gameTree.min().priority();
            SearchNode current = gameTree.delMin();
            WorldState currentBoard = current.board();
            WorldState prevBoard = current.prevBoard();
            for (WorldState x : currentBoard.neighbors()) {
                if (!x.equals(prevBoard)) {
                    SearchNode newNode = new SearchNode(x, current.moves() + 1, current);
                    gameTree.insert(newNode);
                } else {
                    count += 1;
                }
            }
        }
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

}
