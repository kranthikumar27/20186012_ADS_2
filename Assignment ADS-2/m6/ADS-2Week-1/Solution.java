/**
 * Class for page rank.
 */
class PageRank {
	/**
	 * { var_description }
	 */
	Digraph tempDigraph;
	/**
	 * { var_description }
	 */
	double[] firstPR;
	/**
	 * { var_description }
	 */
	double[] newPR;

	/**
	 * Constructs the object.
	 *
	 * @param      digraph  The digraph
	 */
	PageRank(Digraph digraph) {
		firstPR = new double[10];
		newPR = new double[10];
		this.tempDigraph = digraph;
		for (int i = 0; i < digraph.V(); i++) {
			firstPR[i] = 1.0 / tempDigraph.V();
			newPR[i] = getPageRank(i);
		}
		print();
	}
	/**
     * Returns a string representation.
     */
	public void print() {
		for (int i = 0; i < tempDigraph.V(); i++) {
			System.out.println(i  + " - " + newPR[i]);
		}
	}

	public double getPageRank(int v) {
		for (int i = 0; i < tempDigraph.V(); i++) {
			firstPR[i] = 1.0 / tempDigraph.V();
			int inDegree = tempDigraph.indegree(v);
			if (inDegree == 0.0) {
				return 0.0;
			} else {
				double r = firstPR[i] / inDegree;
				return r;
			}
		}
		return -10.4;
	}

}
/**
 * Class for web search.
 */
class WebSearch {

}

/**
 * Class for solution.
 */
public class Solution {
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		In scan = new In();
		// read the first line of the input to get the number of vertices
		int numOfVertices = Integer.parseInt(scan.readLine());
		Digraph diobj = new Digraph(numOfVertices);
		while (numOfVertices > 0) {
			String[] tokens = scan.readLine().split(" ");
			int v = Integer.parseInt(tokens[0]);
			for (int i = 1; i < tokens.length; i++) {
				diobj.addEdge(v, Integer.parseInt(tokens[i]));
			}

			// iterate count of vertices times
			// to read the adjacency list from std input
			// and build the graph
			numOfVertices--;
		}
		System.out.println(diobj);
		PageRank probj = new PageRank(diobj);

		// Create page rank object and pass the graph object to the constructor

		// print the page rank object

		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor

		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
	}
}