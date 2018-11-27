import java.util.Arrays;
import java.util.ArrayList;
/**
 * Class for word net.
 */
public class WordNet {
    /**
     * { var_description }
     */
    ArrayList<String> synsetsList = new ArrayList<String>();
    /**
     * { item_description }.
     */
    private LinearProbingHashST<String, ArrayList<Integer>> hashObj;
    /**
     * { var_description }
     */
    private SAP sapObj;
    /**
     * { var_description }
     */
    Digraph digraphObj;
    /**
     * { var_description }
     */
    int numOfVertices;
    /**
     * Constructs the object.
     *
     * @param      synsets    The synsets
     * @param      hypernyms  The hypernyms
     */
    public WordNet(String synsets, String hypernyms) {
        //reverseSt = new LinearProbingHashST<Integer, String>();
        numOfVertices = 0;
        hashObj = new LinearProbingHashST<String, ArrayList<Integer>>();
        parseMySynsetFile(synsets, hypernyms);
        sapObj = new SAP(digraphObj);
    }
    /**
     * parseMySynsetFile.
     *
     * @param      filename  The filename
     */
    void parseMySynsetFile(String filename, String hypernyms) {
        int id = 0;
        //int numOfVertices = 0;
            
            In inObj = new In(filename);
            while (!inObj.isEmpty()) {
                this.numOfVertices++;
                String[] synsetArray = inObj.readLine().split(",");
                id = Integer.parseInt(synsetArray[0]);
                //listObj.add(id);
                synsetsList.add(id, synsetArray[1]);
                String[] nounsArray = synsetArray[1].split(" ");
                for (int i = 0; i < nounsArray.length; i++) {
                    //reverseSt.put(Integer.parseInt(synsetArray[0]), synsetArray[1]);
                    ArrayList<Integer> listObj;
                    if (hashObj.contains(nounsArray[i])) {
                        listObj = hashObj.get(nounsArray[i]);
                        listObj.add(id);
                    } else {
                        listObj = new ArrayList<Integer>();
                        listObj.add(id);
                    }
                    hashObj.put(nounsArray[i], listObj);
                }
            }
            //Digraph digraphObj = new Digraph(numOfVertices);
            digraphObj = new Digraph(numOfVertices);
            parseMyHypernymsFile(hypernyms, digraphObj, numOfVertices);
        } 
    

    void parseMyHypernymsFile(String hypernyms, Digraph tempObj, int numOfVertices) {
            In inObj = new In(hypernyms);
            while (!inObj.isEmpty()) {
                String[] synsetArray = inObj.readLine().split(",");
                int v = Integer.parseInt(synsetArray[0]);
                for (int i = 1; i < synsetArray.length; i++) {
                    //System.out.println(v+"\t"+i);
                    tempObj.addEdge(v, Integer.parseInt(synsetArray[i]));
                }
                // int v = Integer.parseInt(synsetArray[0]);
                // int w = Integer.parseInt(fileArray[1]);
                //tempObj.addEdge(v, w);
            }
            
        } 
    

    // // returns all WordNet nouns
    public Iterable<String> nouns() {
        return hashObj.keys();
    }

    //is the word a WordNet noun?
    public boolean isNoun(String word) {
        return hashObj.contains(word);
    }

    // // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) {
           System.out.println("IllegalArgumentException");
        }
        Iterable<Integer> noun1 = hashObj.get(nounA);
        Iterable<Integer> noun2 = hashObj.get(nounB);
        return sapObj.length(noun1, noun2);
    }

    // // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        Iterable<Integer> noun1 = hashObj.get(nounA);
        Iterable<Integer> noun2 = hashObj.get(nounB);
        if (!isNoun(nounA) || !isNoun(nounB)) {
           System.out.println("IllegalArgumentException");
        }
        int id = sapObj.ancestor(noun1, noun2);
        return synsetsList.get(id);
        //return "";
    }

    public void display() {
        DirectedCycle dc = new DirectedCycle(digraphObj);
            int count = 0;
            for (int i = 0; i < numOfVertices; i++) {
                if (digraphObj.outdegree(i) == 0) {
                    count++;
                }

            }
            if (count > 1) {
                System.out.println("Multiple roots");
                return;
            }
            //System.out.println(digraphObj);
            if (dc.hasCycle()) {
                System.out.println("Cycle detected");
            } else {
                System.out.println(digraphObj);
            }
    }

    // // do unit testing of this class
    // public static void main(String[] args)
}