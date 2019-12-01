package easy;

import java.util.*;

/*
    Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 */
public class MinimumAbsoluteDifferenceInBST {

    private List<Integer> f = new ArrayList<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        MinimumAbsoluteDifferenceInBST minimumAbsoluteDifferenceInBST = new MinimumAbsoluteDifferenceInBST();
        System.out.println(minimumAbsoluteDifferenceInBST.getMinimumDifference(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root) {

        if (root == null) return;
        f.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public int getMinimumDifference(TreeNode root) {

        dfs(root);
        int n = f.size();
        Collections.sort(f);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) result = Math.min(result, Math.abs(f.get(i) - f.get(i+1)));
        return result;
    }

}
