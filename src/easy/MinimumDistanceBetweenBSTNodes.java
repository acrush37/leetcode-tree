package easy;

/*
    Given a Binary Search Tree (BST) with the root node root, return the minimum
    difference between the values of any two different nodes in the tree.
 */
public class MinimumDistanceBetweenBSTNodes {

    private int result = Integer.MAX_VALUE;

    public static void main(String... args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        MinimumDistanceBetweenBSTNodes minimumDistanceBetweenBSTNodes = new MinimumDistanceBetweenBSTNodes();
        System.out.println(minimumDistanceBetweenBSTNodes.minDiffInBST(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root, Integer left, Integer right) {

        if (root == null) return;
        if (left != null) result = Math.min(result, Math.abs(root.val - left));
        if (right != null) result = Math.min(result, Math.abs(root.val - right));
        dfs(root.left, left, root.val);
        dfs(root.right, root.val, right);
    }

    public int minDiffInBST(TreeNode root) {
        dfs(root, null, null);
        return result;
    }

}
