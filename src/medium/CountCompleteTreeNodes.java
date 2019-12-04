package medium;

import java.util.LinkedList;
import java.util.Queue;

/*
    Given a complete binary tree, count the number of nodes.
 */
public class CountCompleteTreeNodes {

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        System.out.println(countCompleteTreeNodes.countNodes(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {

        if (root == null) return 0;
        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            result++;
            TreeNode node = q.poll();
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        return result;
    }

}
