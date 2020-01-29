package easy;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
    A subtree of s is a tree consists of a node in s and all of this node's descendants.
    The tree s could also be considered as a subtree of itself.
 */
public class SubtreeOfAnotherTree {

    public static void main(String... args) {

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.left.left = new TreeNode(0);
        s.left.right = new TreeNode(2);
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        System.out.println(subtreeOfAnotherTree.isSubtree(s, t));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean dfs(TreeNode s, TreeNode t) {

        if (s == null) return t == null;
        if (t == null) return s == null;
        return s.val == t.val && dfs(s.left, t.left) && dfs(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(s);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();
            if (node.val == t.val && dfs(node, t)) return true;
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        return false;
    }

}
