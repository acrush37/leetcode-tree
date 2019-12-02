package easy;

/*
    Given a binary search tree and the lowest and highest boundaries as L and R,
    trim the tree so that all its elements lies in [L, R] (R >= L).

    You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 */
public class TrimBinarySearchTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        TrimBinarySearchTree trimBinarySearchTree = new TrimBinarySearchTree();
        System.out.println(trimBinarySearchTree.trimBST(root, 3, 4));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null) return null;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

}
