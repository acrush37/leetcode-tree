package medium;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    Given a binary tree, determine if it is a complete binary tree.
 */
public class CheckCompletenessOfBinaryTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        CheckCompletenessOfBinaryTree checkCompletenessOfBinaryTree = new CheckCompletenessOfBinaryTree();
        System.out.println(checkCompletenessOfBinaryTree.isCompleteTree(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isCompleteTree(TreeNode root) {

        int[] f = new int[100];
        boolean[] t = new boolean[100];
        Queue<Object[]> q = new ArrayDeque<>();
        q.offer(new Object[]{root, 0});

        while (!q.isEmpty()) {

            Object[] x = q.poll();
            TreeNode node = (TreeNode) x[0];
            if (node.left == null && node.right != null) return false;
            int depth = (int) x[1];
            if (t[depth] && node.left != null) return false;
            f[depth]++;
            if (node.left == null || node.right == null) t[depth] = true;
            if (node.left != null) q.offer(new Object[]{node.left, 1 + depth});
            if (node.right != null) q.offer(new Object[]{node.right, 1 + depth});
        }

        for (int i = 99; i >= 1; i--)
            if (f[i] != 0) {

                for (int j = 1; j < i; j++)
                    if (f[j] < Math.pow(2, j))
                        return false;

                return true;
            }

        return true;
    }

}
