package medium;

import java.util.HashSet;
import java.util.Set;

/*
    We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

    Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 */
public class BinaryTreePruning {

    private Set<TreeNode> t = new HashSet<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        BinaryTreePruning binaryTreePruning = new BinaryTreePruning();
        System.out.println(binaryTreePruning.pruneTree(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean dfs(TreeNode root) {

        if (root == null) return true;
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        boolean flag = root.val == 0 && left && right;
        if (flag) t.add(root);
        return flag;
    }

    private void remove(TreeNode root) {

        if (root.left != null) {
            if (t.contains(root.left)) root.left = null;
            else remove(root.left);
        }

        if (root.right != null) {
            if (t.contains(root.right)) root.right = null;
            else remove(root.right);
        }
    }

    public TreeNode pruneTree(TreeNode root) {

        if (root == null) return null;
        dfs(root);
        if (t.contains(root)) return null;
        remove(root);
        return root;
    }

}
