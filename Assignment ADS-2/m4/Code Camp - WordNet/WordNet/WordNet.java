import java.util.Arrays;
public class WordNet {

	// constructor takes the name of the two input files
	public WordNet(String synsets, String hypernyms) {
		synsetsFile(synsets, hypernyms);
		//hypernymsFile(hypernyms);

	}
	void synsetsFile(String filename, String hypernyms) {
		int id = 0;
		int numOfVertices = 0;
		try {
			In inObj = new In(filename);
			while (!inObj.isEmpty()) {
				numOfVertices++;
				String[] tokens = inObj.readString().split(",");
				id = Integer.parseInt(tokens[0]);
				String[] nouns = tokens[1].split(" ");
			}
			Digraph diObj = new Digraph(numOfVertices);
			hypernymsFile(hypernyms, diObj);
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	void hypernymsFile(String hypernyms, Digraph diObj) {
		In inobj = new In(hypernyms);
		while (!inobj.isEmpty()) {
			String[] tokens = inobj.readString().split(",");
			for (int i = 1; i < tokens.length; i++) {
				diObj.addEdge(Integer.parseInt(tokens[0]),
				 Integer.parseInt(tokens[i]));
			}
			//System.out.println(Arrays.toString(tokens));
		}
		//System.out.println(diObj);
		DirectedCycle dc = new DirectedCycle(diObj);
		if (dc.hasCycle()) {
		 	System.out.println("Cycle detected");
		 } else {
		 	System.out.println(diObj);
		 }
	}
}



// // returns all WordNet nouns
// public Iterable<String> nouns()

// // is the word a WordNet noun?
// public boolean isNoun(String word)

// // distance between nounA and nounB (defined below)
// public int distance(String nounA, String nounB)

// // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
// // in a shortest ancestral path (defined below)
// public String sap(String nounA, String nounB)

// // do unit testing of this class
// public static void main(String[] args)

