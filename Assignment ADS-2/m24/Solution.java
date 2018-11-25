import java.util.Scanner;
 public class Solution {
    private Solution() {
        //unssed constructor.
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        for (int i = 0; i < input; i++) {
            int token = Integer.parseInt(scan.nextLine());
            if (!bst.contains(token)) {
                bst.put(token, 1);
            } else {
                bst.put(token, bst.get(token) + 1);
            }
        }
        bst.display();
    }
}