package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given a binary tree root and an integer target, delete all the leaf nodes with value target.

    Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node
    and has the value target, it should also be deleted (you need to continue doing that until you can't).
 */
public class DeleteLeavesWithGivenValue {

    private Map<TreeNode, TreeNode> f = new HashMap<>();

    public static void main(String... args) {

        DeleteLeavesWithGivenValue deleteLeavesWithGivenValue = new DeleteLeavesWithGivenValue();
        System.out.println(deleteLeavesWithGivenValue.removeLeafNodes(null, 0));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs1(int target, TreeNode root, List<TreeNode> t) {

        if (root.left != null) {
            f.put(root.left, root);
            dfs1(target, root.left, t);
        }

        if (root.right != null) {
            f.put(root.right, root);
            dfs1(target, root.right, t);
        }

        if (root.val == target && root.left == null && root.right == null) t.add(root);
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if (root == null) return null;
        List<TreeNode> a = new ArrayList<>();
        dfs1(target, root, a);

        while (true) {

            if (a.isEmpty()) return root;
            List<TreeNode> b = new ArrayList<>();

            for (TreeNode node : a) {

                TreeNode p = f.get(node);
                if (p == null) return null;

                if (p.left == node) p.left = null;
                else p.right = null;

                if (p.val == target && p.left == null && p.right == null) b.add(p);
            }

            a = b;
        }
    }

}
