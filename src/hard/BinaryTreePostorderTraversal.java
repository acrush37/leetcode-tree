package hard;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary tree, return the postorder traversal of its nodes' values.
 */
public class BinaryTreePostorderTraversal {

    private List<Integer> result = new ArrayList<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
        System.out.println(binaryTreePostorderTraversal.postorderTraversal(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root) {

        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        result.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }

}
