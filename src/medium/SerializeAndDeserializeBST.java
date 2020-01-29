package medium;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    Design an algorithm to serialize and deserialize a binary search tree.
 */
public class SerializeAndDeserializeBST {

    public static void main(String... args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        SerializeAndDeserializeBST serializeAndDeserializeBST = new SerializeAndDeserializeBST();
        String s = serializeAndDeserializeBST.serialize(root);
        System.out.println(serializeAndDeserializeBST.deserialize(s));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String serialize(TreeNode root) {

        if (root == null) return ",*";
        return "," + root.val + serialize(root.left) + serialize(root.right);
    }

    private TreeNode deserialize(Queue<TreeNode> q) {

        if (q.isEmpty()) return null;
        TreeNode node = q.poll();
        if (node == null) return null;
        node.left = deserialize(q);
        node.right = deserialize(q);
        return node;
    }

    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");
        int n = nodes.length;
        if (n == 2) return null;
        Queue<TreeNode> q = new ArrayDeque<>();

        for (int i = 1; i < n; i++)
            q.offer("*".equals(nodes[i]) ? null : new TreeNode(Integer.parseInt(nodes[i])));

        return deserialize(q);
    }

}
