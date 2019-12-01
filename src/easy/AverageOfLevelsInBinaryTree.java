package easy;

import java.util.*;

/*
    Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 */
public class AverageOfLevelsInBinaryTree {

    private Map<Integer, List<Integer>> m = new TreeMap<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree = new AverageOfLevelsInBinaryTree();
        System.out.println(averageOfLevelsInBinaryTree.averageOfLevels(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(int k, TreeNode root) {

        if (root == null) return;
        List<Integer> f = m.get(k);
        if (f == null) f = new ArrayList<>();
        f.add(root.val);
        m.put(k, f);
        dfs(k+1, root.left);
        dfs(k+1, root.right);
    }

    public List<Double> averageOfLevels(TreeNode root) {

        dfs(0, root);
        List<Double> result = new ArrayList<>();
        Collection<List<Integer>> list = m.values();

        for (List<Integer> t : list) {

            double s = 0;
            for (int val : t) s += val;
            result.add(s / t.size());
        }

        return result;
    }

}
