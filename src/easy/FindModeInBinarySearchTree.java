package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 */
public class FindModeInBinarySearchTree {

    private int last, current;

    private List<Integer> list = new ArrayList<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(6);
        FindModeInBinarySearchTree findModeInBinarySearchTree = new FindModeInBinarySearchTree();
        System.out.println(findModeInBinarySearchTree.findMode(root));
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
        int n = list.size() - 1;

        if (current == 0) {
            current = 1;
            list.add(root.val);
        } else if (root.val == list.get(n)) current++;
        else {
            if (current < last) list.remove(n);
            else if (current > last) {
                int x = list.get(n);
                list.clear();
                list.add(x);
            }

            list.add(root.val);
            last = Math.max(last, current);
            current = 1;
        }

        dfs(root.right);
    }

    public int[] findMode(TreeNode root) {

        if (root == null) return new int[0];
        dfs(root);
        int n = list.size();
        if (current > last) return new int[]{list.get(n-1)};
        if (current < last) n--;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = list.get(i);
        return result;
    }

}
