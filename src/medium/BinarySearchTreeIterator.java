package medium;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    Implement an iterator over a binary search tree (BST).
    Your iterator will be initialized with the root node of a BST.

    Calling next() will return the next smallest number in the BST.
 */
public class BinarySearchTreeIterator {

    private Queue<Integer> q = new ArrayDeque<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BinarySearchTreeIterator binarySearchTreeIterator = new BinarySearchTreeIterator(root);
        System.out.println(binarySearchTreeIterator.next());
        System.out.println(binarySearchTreeIterator.next());
        System.out.println(binarySearchTreeIterator.next());
        System.out.println(binarySearchTreeIterator.hasNext());
        System.out.println(binarySearchTreeIterator.next());
        System.out.println(binarySearchTreeIterator.hasNext());
        System.out.println(binarySearchTreeIterator.next());
        System.out.println(binarySearchTreeIterator.hasNext());
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public BinarySearchTreeIterator(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {

        if (root == null) return;
        dfs(root.left);
        q.offer(root.val);
        dfs(root.right);
    }

    public int next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

}
