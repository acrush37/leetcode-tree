package hard;

import java.util.HashSet;
import java.util.Set;

/*
    An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.

    The ith edge connects nodes edges[i][0] and edges[i][1] together.

    Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.
 */
public class SumOfDistancesInTree {

    private int[] a, result;

    private Set<Integer>[] t;

    public static void main(String... args) {

        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        SumOfDistancesInTree sumOfDistancesInTree = new SumOfDistancesInTree();
        System.out.println(sumOfDistancesInTree.sumOfDistancesInTree(6, edges));
    }

    private int dfs1(int n, int parent) {

        a[n] = 1;

        for (int child : t[n])
            if (child != parent) {
                a[n] += a[child] != 0 ? a[child] : (a[child] = dfs1(child, n));
                result[n] += result[child] + a[child];
            }

        return a[n];
    }

    private void dfs2(int n, int parent, int N) {

        for (int child : t[n])
            if (child != parent) {
                result[child] = result[n] + N - (a[child] << 1);
                dfs2(child, n, N);
            }
    }

    public int[] sumOfDistancesInTree(int N, int[][] edges) {

        t = new Set[N];
        a = new int[N];
        result = new int[N];
        for (int i = 0; i < N; i++) t[i] = new HashSet<>();

        for (int[] x : edges) {
            t[x[0]].add(x[1]);
            t[x[1]].add(x[0]);
        }

        dfs1(0, -1);
        dfs2(0, -1, N);
        return result;
    }

}
