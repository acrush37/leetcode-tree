package medium;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
    Given a binary tree, write a function to get the maximum width of the given tree.
    The width of a tree is the maximum width among all levels.
    The binary tree has the same structure as a full binary tree, but some nodes are null.

    The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null
    nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 */
public class MaximumWidthOfBinaryTree {

    private Map<Integer, int[]> m = new HashMap<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
        System.out.println(maximumWidthOfBinaryTree.widthOfBinaryTree(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(int k, int n, TreeNode root) {

        int[] f = m.get(n);

        if (f == null) m.put(n, new int[]{k, k});
        else {
            if (k < f[0]) f[0] = k;
            else if (k > f[1]) f[1] = k;
            m.put(n, f);
        }

        k = 1 + (k << 1);
        if (root.left != null) dfs(k, n+1, root.left);
        if (root.right != null) dfs(k+1, n+1, root.right);
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;
        int result = 0;
        dfs(0, 0, root);
        Collection<int[]> values = m.values();
        for (int[] f : values) result = Math.max(result, f[1] - f[0] + 1);
        return result;
    }

}
