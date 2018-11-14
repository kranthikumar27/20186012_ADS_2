import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * default constructor.
     */
    private Solution() {
        //default constructor.
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        String[] words = loadWords();
        //Your code goes here...
        TST<Integer> tst = new TST<Integer>();
        Scanner scan = new Scanner(System.in);
        String prefix = scan.nextLine();
        int j = 0;
        for (String each : words) {
            SuffixArray suffixobj = new SuffixArray(each);
            for (int i = 0; i < each.length(); i++) {
                tst.put(suffixobj.select(i), j++);
            }
        }
        for (String each : tst.keysWithPrefix(prefix)) {
            System.out.println(each);
        }
    }
    /**.
     * Loads words.
     *
     * @return     { description_of_the_return_value }
     */
    public static String[] loadWords() {
        In in = new In("/Files/dictionary-algs4.txt");
        String[] words = in.readAllStrings();
        return words;
    }
}

