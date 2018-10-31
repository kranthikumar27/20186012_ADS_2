/**.
 * Class for directed cycle.
 */
class DirectedCycle {
    /**.
     * variable declaration.
     */
    private boolean[] marked;
    /**.
     * // marked[v] = has vertex v been marked?.
     */
    private int[] edgeTo;
    /**.
     * variable declaration.
     */
    private boolean[] onStack;
    /**.
     * variable declaration.
     */
    private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)
    /**.
     * Constructs the object.
     *
     * @param      G     { parameter_description }.
     */
    public DirectedCycle(Digraph G) {
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v] && cycle == null) dfs(G, v);
    }
    /**.
     * { function_description }.
     *
     * @param      G     { parameter_description }.
     * @param      v     { parameter_description }.
     */
    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) return;

            // found new vertex, so recur
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }

            // trace back directed cycle
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                assert check();
            }
        }
        onStack[v] = false;
    }

    /**.
     * Does the digraph have a directed cycle?
     * @return {@code true} if the digraph has a directed cycle, {@code false} otherwise
     */
    public boolean hasCycle() {
        if (cycle != null) {
            return true;
        }
        return false;
    }
    /**.
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
    /**.
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    private boolean check() {
        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.out.println("cycle begins with %d and ends with %d\n" + first + last);
                return false;
            }
        }
        return true;
    }
}