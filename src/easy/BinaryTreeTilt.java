package easy;

/*
    Given a binary tree, return the tilt of the whole tree.

    The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values.
    Null node has tilt 0.

    The tilt of the whole tree is defined as the sum of all nodes' tilt.
 */
public class BinaryTreeTilt {

    private int result;

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        BinaryTreeTilt binaryTreeTilt = new BinaryTreeTilt();
        System.out.println(binaryTreeTilt.findTilt(root));
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
        result += Math.abs(left - right);
        return left + right + root.val;
    }

    public int findTilt(TreeNode root) {
        dfs(root);
        return result;
    }

}
