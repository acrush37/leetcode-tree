package hard;

/*
    Given a non-empty binary tree, find the maximum path sum.

    For this problem, a path is defined as any sequence of nodes from some starting
    node to any node in the tree along the parent-child connections.

    The path must contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {

    private int result = Integer.MIN_VALUE;

    public static void main(String... args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.right = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(1);
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        System.out.println(binaryTreeMaximumPathSum.maxPathSum(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int dfs(TreeNode root) {

        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val;

        if (left < 0) result = Math.max(result, right < 0 ? sum : (sum += right));
        else if (right < 0) result = Math.max(result, sum += left);
        else {
            result = Math.max(result, sum + left + right);
            sum += left > right ? left : right;
        }

        return sum;
    }

    public int maxPathSum(TreeNode root) {

        dfs(root);
        return result;
    }

}
