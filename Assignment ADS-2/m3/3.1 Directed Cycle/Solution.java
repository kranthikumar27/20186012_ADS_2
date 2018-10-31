import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //default constructor.
    }
    /**.
     * Main method
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int numofvertices = Integer.parseInt(scan.nextLine());
        int numofedges = Integer.parseInt(scan.nextLine());
        Digraph objdg = new Digraph(numofvertices);
        while (numofedges > 0) {
            String[] connections = scan.nextLine().split(" ");
            objdg.addEdge(Integer.parseInt(connections[0]),
                          Integer.parseInt(connections[1]));
            numofedges--;
        }
        DirectedCycle objdc = new DirectedCycle(objdg);
        if (objdc.hasCycle()) {
            System.out.println("Cycle exists.");
        } else {
            System.out.println("Cycle doesn't exists.");
        }
    }
}
