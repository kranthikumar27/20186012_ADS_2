import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//default constructor.
	}
	/**
	 * main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numofvertices = Integer.parseInt(scan.nextLine());
		int numofedges = Integer.parseInt(scan.nextLine());
		Graph objgraph = new Graph(numofvertices);
		while (scan.hasNext()) {
			String[] input = scan.nextLine().split(" ");
			objgraph.addEdge(Integer.parseInt(input[0]),
			                 Integer.parseInt(input[1]));
		}
		DirectedCycle objdc = new DirectedCycle(objgraph);
        if (objdc.isBipartite()) {
            System.out.println("Graph is Bipartite");
        } else {
            System.out.println("Graph is not a bipartite");
        }
	}
}