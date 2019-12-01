package easy;

import java.util.HashMap;
import java.util.Map;

/*
    Given a Binary Search Tree and a target number, return true if there exist
    two elements in the BST such that their sum is equal to the given target.
 */
public class TwoSumIVInputIsBST {

    private boolean result;

    private Map<Integer, Integer> m = new HashMap<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TwoSumIVInputIsBST twoSumIVInputIsBST = new TwoSumIVInputIsBST();
        System.out.println(twoSumIVInputIsBST.findTarget(root, 9));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root, int k) {

        if (root == null) return;
        Integer x = m.get(k - root.val);

        if (x != null) {
            result = true;
            return;
        }

        x = m.get(root.val);
        m.put(root.val, x == null ? 1 : 1 + x);
        if (!result) dfs(root.left, k);
        if (!result) dfs(root.right, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

}
