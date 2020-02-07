package medium;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    Given the root of a binary tree, then value v and depth d, you need to add a
    row of nodes with value v at the given depth d. The root node is at depth 1.
 */
public class AddOneRowToTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        AddOneRowToTree addOneRowToTree = new AddOneRowToTree();
        System.out.println(addOneRowToTree.addOneRow(root, 1, 2));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d == 1) {

            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        Queue<Object[]> q = new ArrayDeque<>();
        q.offer(new Object[]{2, root});

        while (!q.isEmpty()) {

            Object[] o = q.poll();
            int depth = (int) o[0];
            if (depth > d) return root;
            TreeNode node = (TreeNode) o[1];

            if (node.left != null) {

                q.offer(new Object[]{depth + 1, node.left});

                if (depth == d) {

                    TreeNode node1 = new TreeNode(v);
                    node1.left = node.left;
                    node.left = node1;
                }
            } else if (depth == d) node.left = new TreeNode(v);

            if (node.right != null) {

                q.offer(new Object[]{depth + 1, node.right});

                if (depth == d) {

                    TreeNode node1 = new TreeNode(v);
                    node1.right = node.right;
                    node.right = node1;
                }
            } else if (depth == d) node.right = new TreeNode(v);
        }

        return root;
    }

}
