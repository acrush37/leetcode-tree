package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary tree, return the sum of values of its deepest leaves.
 */
public class DeepestLeavesSum {

    private int max;

    private List<Integer> t = new ArrayList<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();
        System.out.println(deepestLeavesSum.deepestLeavesSum(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(int k, TreeNode root) {

        if (root == null) return;

        if (k == max) t.add(root.val);
        else if (k > max) {
            max = k;
            t.clear();
            t.add(root.val);
        }

        dfs(k+1, root.left);
        dfs(k+1, root.right);
    }

    public int deepestLeavesSum(TreeNode root) {

        dfs(0, root);
        int result = 0;
        for (int x : t) result += x;
        return result;
    }

}
