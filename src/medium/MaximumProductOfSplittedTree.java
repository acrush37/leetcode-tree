package medium;

/*
    Given a binary tree root. Split the binary tree into two subtrees by removing
    1 edge such that the product of the sums of the subtrees are maximized.

    Since the answer may be too large, return it modulo 10^9 + 7.
 */
public class MaximumProductOfSplittedTree {

    private long result;

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        MaximumProductOfSplittedTree maximumProductOfSplittedTree = new MaximumProductOfSplittedTree();
        System.out.println(maximumProductOfSplittedTree.maxProduct(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private long dfs1(TreeNode root) {

        if (root == null) return 0;
        return root.val + dfs1(root.left) + dfs1(root.right);
    }

    private long dfs2(TreeNode root, long total) {

        if (root == null) return 0;
        long sum = root.val + dfs2(root.left, total) + dfs2(root.right, total);
        result = Math.max(result, sum * (total - sum));
        return sum;
    }

    public int maxProduct(TreeNode root) {

        dfs2(root, dfs1(root));
        return (int) (result % 1000000007);
    }

}
