package hard;

/*
    The given input is a directed graph that started as a rooted tree with N nodes
    (with distinct values 1, 2, ..., N), with one additional directed edge added.
    The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

    The resulting graph is given as a 2D-array of edges.
    Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

    Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes.
    If there are multiple answers, return the answer that occurs last in the given 2D-array.
 */
public class RedundantConnectionII {

    public static void main(String... args) {

        int[][] edges = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
        RedundantConnectionII redundantConnectionII = new RedundantConnectionII();
        System.out.println(redundantConnectionII.findRedundantDirectedConnection(edges));
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;
        int[] p = new int[n+1];
        int[] f = new int[n+1];
        int[] e1 = null, e2 = null, cycle = null;

        for (int[] e : edges) {

            int x = e[0];
            int y = e[1];

            if (p[y] != 0) {
                e1 = new int[]{p[y], y};
                e2 = new int[]{x, y};
                continue;
            }

            p[y] = x;
            while (f[x] != 0) x = f[x];
            while (f[y] != 0) y = f[y];
            if (x == y) cycle = e;
            else f[y] = x;
        }

        if (e1 == null) return cycle;
        return cycle == null ? e2 : e1;
    }

}
