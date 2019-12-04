package medium;

/*
    The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added.
    The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

    Return an edge that can be removed so that the resulting graph is a tree of N nodes.
    If there are multiple answers, return the answer that occurs last in the given 2D-array.
    The answer edge [u, v] should be in the same format, with u < v.
 */
public class RedundantConnection {

    public static void main(String... args) {

        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        RedundantConnection redundantConnection = new RedundantConnection();
        System.out.println(redundantConnection.findRedundantConnection(edges));
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        Integer[] f = new Integer[n+1];

        for (int[] e : edges) {

            int x = e[0];
            int y = e[1];
            while (f[x] != null) x = f[x];
            while (f[y] != null) y = f[y];
            if (x == y) return e;
            f[x] = y;
        }

        return null;
    }

}
