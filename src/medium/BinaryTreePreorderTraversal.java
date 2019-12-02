package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreorderTraversal {

    private List<Integer> result = new ArrayList<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
        System.out.println(binaryTreePreorderTraversal.preorderTraversal(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root) {

        if (root == null) return;
        result.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }

}
