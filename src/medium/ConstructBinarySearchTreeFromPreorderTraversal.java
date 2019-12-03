package medium;

import java.util.Arrays;

/*
    Return the root node of a binary search tree that matches the given preorder traversal.
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    public static void main(String... args) {

        int[] preorder = {8, 5, 1, 7, 10, 12};
        ConstructBinarySearchTreeFromPreorderTraversal constructBinarySearchTreeFromPreorderTraversal = new ConstructBinarySearchTreeFromPreorderTraversal();
        System.out.println(constructBinarySearchTreeFromPreorderTraversal.bstFromPreorder(preorder));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        int n = preorder.length;
        if (n == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i = 1;
        while (i < n && preorder[i] < preorder[0]) i++;
        if (i > 1) root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, i));
        if (i < n) root.right = bstFromPreorder(Arrays.copyOfRange(preorder, i, n));
        return root;
    }

}
