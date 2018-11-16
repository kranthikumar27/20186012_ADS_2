import java.util.Set;
public class BoggleSolver {
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    private TrieST<Integer> dictionaryTrie;
    private Set<String> validWords;
    int[] points = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    public BoggleSolver(String[] dictionary) {
        dictionaryTrie = new TrieST<Integer>();
        for (String word : dictionary) {
            if (word.length() >= 8) {
                dictionaryTrie.put(word, 11);
            } else {
                dictionaryTrie.put(word, points[word.length()]);
            }
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        Boolean[][] marked;
        for (int i = 0;i < board.rows(); i++) {
            for (int j = 1;j < board.cols(); j++) {
                marked = new Boolean[board.rows()][board.cols()];
                dfs(board, marked, i, j, validWords);
            }
        }
        return new Bag<String>();
    }

    public void dfs(BoggleBoard board, Boolean[][] marked,
     int rows, int cols, Set<String> validword) {
        marked[rows][cols] = true;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if (dictionaryTrie.contains(word)) {
            return dictionaryTrie.get(word);
        }
        return 0;
    }
}