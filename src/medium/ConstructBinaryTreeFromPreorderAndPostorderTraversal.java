package medium;

import java.util.Arrays;

/*
    Return any binary tree that matches the given preorder and postorder traversals.

    Values in the traversals pre and post are distinct positive integers.
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public static void main(String... args) {

        int[] pre = {2, 1};
        int[] post = {1, 2};
        ConstructBinaryTreeFromPreorderAndPostorderTraversal constructBinaryTreeFromPreorderAndPostorderTraversal = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();
        System.out.println(constructBinaryTreeFromPreorderAndPostorderTraversal.constructFromPrePost(pre, post));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        int n = pre.length;
        TreeNode root = new TreeNode(pre[0]);
        if (n == 1) return root;
        int i = 0;
        while (i < n-1 && post[i] != pre[1]) i++;

        if (i == n-1) root.right = constructFromPrePost(Arrays.copyOfRange(pre, 1, n), Arrays.copyOfRange(post, 0, n-1));
        else {
            root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, i+2), Arrays.copyOfRange(post, 0, i+1));
            if (i < n-2) root.right = constructFromPrePost(Arrays.copyOfRange(pre, i+2, n), Arrays.copyOfRange(post, i+1, n-1));
        }

        return root;
    }

}
