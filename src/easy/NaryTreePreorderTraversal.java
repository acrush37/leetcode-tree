package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an n-ary tree, return the preorder traversal of its nodes' values.
 */
public class NaryTreePreorderTraversal {

    private List<Integer> result = new ArrayList<>();

    public static void main(String... args) {

        Node root = new Node(1);
        root.children = Arrays.asList(new Node(3), new Node(2), new Node(4));
        NaryTreePreorderTraversal naryTreePreorderTraversal = new NaryTreePreorderTraversal();
        System.out.println(naryTreePreorderTraversal.preorder(root));
    }

    static class Node {

        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private void dfs(Node root) {

        if (root == null) return;
        result.add(root.val);

        if (root.children != null)
            for (Node node : root.children)
                dfs(node);
    }

    public List<Integer> preorder(Node root) {
        dfs(root);
        return result;
    }

}
