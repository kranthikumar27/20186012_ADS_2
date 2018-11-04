/**
 * Class for page rank.
 */
class PageRank {
	/**
	 * { var_description }
	 */
	private Digraph graaph;
	/**
	 * { var_description }
	 */
	private Digraph revdg;
	/**
	 * { var_description }
	 */
	private int vertices;
	private Double[] pr;

	
	/**
	 * Constructs the object.
	 *
	 * @param      digraph  The digraph
	 */
	PageRank(Digraph digraph) {
		// firstPR = new double[10];
		// newPR = new double[10];
		// this.tempDigraph = digraph;
		// for (int i = 0; i < digraph.V(); i++) {
		// 	firstPR[i] = 1.0 / tempDigraph.V();
		// 	newPR[i] = getPageRank(i);
		// }
		// print();
		this.graaph = graaph;
		this.revdg = graaph.reverse();
		this.vertices = graaph.V();
		pr = new Double[vertices];
		int ver = graaph.V();
		for (int i = 0; i < vertices; i++) {
			pr[i] = 1.0 / ver;
		}
		prCalculation();
	}

	public void prCalculation() {
        for (int i = 0; i < vertices; i++) {
            if (graaph.outdegree(i) == 0) {
                for (int j = 0; j < vertices; j++) {
                    if (i != j) {
                        graaph.addEdge(i, j);
                    }
                }
            }
        }
        final int thousand = 1000;
        for (int k = 1; k < thousand; k++) {
            Double[] temppr = new Double[vertices];
            for (int i = 0; i < vertices; i++) {
                Double newpr = 0.0;
                for (int element : graaph.reverse().adj(i)) {
                    newpr = newpr + pr[element] / graaph.outdegree(element);
                }
                temppr[i] = newpr;
            }
            pr = temppr;
        }
    }

    public Double getPageRank(final int v) {
        return pr[v];
    }
    /**.
     * method to printer
     */
    public void display() {
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " - " + pr[i]);
        }
    }

	/**
	 * Returns a string representation.
	 */
	// public void print() {
	// 	for (int i = 0; i < tempDigraph.V(); i++) {
	// 		System.out.println(i  + " - " + newPR[i]);
	// 	}
	// }

	// public double getPageRank(int v) {
	// 	for (int i = 0; i < tempDigraph.V(); i++) {
	// 		firstPR[i] = 1.0 / tempDigraph.V();
	// 		int inDegree = tempDigraph.indegree(v);
	// 		if (inDegree == 0.0) {
	// 			return 0.0;
	// 		} else {
	// 			double r = firstPR[i] / inDegree;
	// 			return r;
	// 		}
	// 	}
	// 	return -10.4;
	// }

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
		System.out.println(diobj.toString());
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