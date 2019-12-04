package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
    Construct the maximum tree by the given array and output the root node of this tree.
 */
public class MaximumBinaryTree {

    public static void main(String... args) {

        int[] nums = {3, 2, 1, 6, 0, 5};
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        System.out.println(maximumBinaryTree.constructMaximumBinaryTree(nums));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

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
