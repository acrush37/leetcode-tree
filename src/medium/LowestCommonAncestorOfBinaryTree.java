package medium;

import java.util.*;

/*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
public class LowestCommonAncestorOfBinaryTree {

    public static void main(String... args) {

        LowestCommonAncestorOfBinaryTree lowestCommonAncestorOfBinaryTree = new LowestCommonAncestorOfBinaryTree();
        System.out.println(lowestCommonAncestorOfBinaryTree.lowestCommonAncestor(null, null, null));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val == p.val || root.val == q.val) return root;
        int count = 0;
        Map<TreeNode, TreeNode> f = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if ((node.val == p.val || node.val == q.val) && ++count == 2) {
                Set<TreeNode> t = new HashSet<>();
                do t.add(p); while ((p = f.get(p)) != null);
                do if (t.contains(q)) return q; while ((q = f.get(q)) != null);
            }

            if (node.left != null) {
                f.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                f.put(node.right, node);
                queue.offer(node.right);
            }
        }

        return null;
    }

}
