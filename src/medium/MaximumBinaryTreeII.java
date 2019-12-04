package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    We are given the root node of a maximum tree:
    a tree where every node has a value greater than any other value in its subtree.

    Note that we were not given A directly, only a root node root = Construct(A).

    Suppose B is a copy of A with the value val appended to it.  It is guaranteed that B has unique values.

    Return Construct(B).
 */
public class MaximumBinaryTreeII {

    private List<Integer> list = new ArrayList<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        MaximumBinaryTreeII maximumBinaryTreeII = new MaximumBinaryTreeII();
        System.out.println(maximumBinaryTreeII.insertIntoMaxTree(root, 5));
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
        list.add(root.val);
        dfs(root.right);
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {

        dfs(root);
        list.add(val);
        Integer[] nums = new Integer[list.size()];
        list.toArray(nums);
        return constructMaximumBinaryTree(nums);
    }

    public TreeNode constructMaximumBinaryTree(Integer[] nums) {

        int n = nums.length;
        if (n == 1) return new TreeNode(nums[0]);
        int max = nums[0];
        int p = 0;
        for (int i = 0; i < n; i++) if (nums[i] > max) max = nums[p=i];
        TreeNode root = new TreeNode(nums[p]);
        if (p > 0) root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, p));
        if (p < n-1) root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, p+1, n));
        return root;
    }

}
