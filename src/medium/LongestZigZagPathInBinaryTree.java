package medium;

/*
    Given a binary tree root, a ZigZag path for a binary tree is defined as follow:

    Choose any node in the binary tree and a direction (right or left).
    If the current direction is right then move to the right child of the current node otherwise move to the left child.
    Change the direction from right to left or right to left.
    Repeat the second and third step until you can't move in the tree.
    Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

    Return the longest ZigZag path contained in that tree.
 */
public class LongestZigZagPathInBinaryTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        LongestZigZagPathInBinaryTree longestZigZagPathInBinaryTree = new LongestZigZagPathInBinaryTree();
        System.out.println(longestZigZagPathInBinaryTree.longestZigZag(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int dfs(TreeNode r, boolean t, int n) {

        if (r == null) return n;
        return Math.max(dfs(r.left, true, t ? 0 : n+1), dfs(r.right, false, t ? n+1 : 0));
    }

    public int longestZigZag(TreeNode root) {
        return Math.max(dfs(root.left, true, 0), dfs(root.right, false, 0));
    }

}
