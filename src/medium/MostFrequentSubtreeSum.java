package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given the root of a tree, you are asked to find the most frequent subtree sum.
    The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node
    (including the node itself). So what is the most frequent subtree sum value?
    If there is a tie, return all the values with the highest frequency in any order.
 */
public class MostFrequentSubtreeSum {

    private int max = 0;

    private Map<Integer, Integer> m = new HashMap<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        MostFrequentSubtreeSum mostFrequentSubtreeSum = new MostFrequentSubtreeSum();
        System.out.println(mostFrequentSubtreeSum.findFrequentTreeSum(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int dfs(TreeNode root) {

        if (root == null) return 0;
        int sum = root.val + dfs(root.left) + dfs(root.right);
        Integer count = m.get(sum);
        count = count == null ? 1 : 1 + count;
        max = Math.max(max, count);
        m.put(sum, count);
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        return m.entrySet().stream().filter(x -> x.getValue() == max).mapToInt(x -> x.getKey()).toArray();
    }

}
