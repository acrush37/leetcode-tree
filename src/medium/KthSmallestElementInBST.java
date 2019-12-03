package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 */
public class KthSmallestElementInBST {

    private List<Integer> list = new ArrayList<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();
        System.out.println(kthSmallestElementInBST.kthSmallest(root, 3));
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

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return list.get(k-1);
    }

}
