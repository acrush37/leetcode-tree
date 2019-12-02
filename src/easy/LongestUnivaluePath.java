package easy;

/*
    Given a binary tree, find the length of the longest path where each node in the path has the same value.
    This path may or may not pass through the root.

    The length of path between two nodes is represented by the number of edges between them
 */
public class LongestUnivaluePath {

    private int result;

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
        System.out.println(longestUnivaluePath.longestUnivaluePath(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int dfs(TreeNode root, Integer val) {

        if (root == null) return 0;
        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        result = Math.max(result, left + right);
        return val == null || root.val != val ? 0 : 1 + Math.max(left, right);
    }

    public int longestUnivaluePath(TreeNode root) {
        dfs(root, null);
        return result;
    }

}
