package medium;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    A complete binary tree is a binary tree in which every level, except possibly
    the last, is completely filled, and all nodes are as far left as possible.

    Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:

    CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
    CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that
    the tree remains complete, and returns the value of the parent of the inserted TreeNode;
    CBTInserter.get_root() will return the head node of the tree.
 */
public class CompleteBinaryTreeInserter {

    private int n = 1;

    private TreeNode root;

    private TreeNode[] t = new TreeNode[11001];

    public static void main(String... args) {

        TreeNode node = new TreeNode(1);
        CompleteBinaryTreeInserter completeBinaryTreeInserter = new CompleteBinaryTreeInserter(node);
        completeBinaryTreeInserter.insert(2);
        node = completeBinaryTreeInserter.get_root();
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right);
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public CompleteBinaryTreeInserter(TreeNode root) {

        this.root = root;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(t[1] = root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();
            if (node.left != null) q.offer(t[++n] = node.left);
            if (node.right != null) q.offer(t[++n] = node.right);
        }
    }

    public int insert(int v) {

        t[++n] = new TreeNode(v);
        TreeNode node = t[n >> 1];

        if ((n & 1) == 0) node.left = t[n];
        else node.right = t[n];

        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }

}
