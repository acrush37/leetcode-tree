package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an n-ary tree, return the postorder traversal of its nodes' values.
 */
public class NaryTreePostorderTraversal {

    private List<Integer> result = new ArrayList<>();

    public static void main(String... args) {

        Node root = new Node(1);
        root.children = Arrays.asList(new Node(3), new Node(2), new Node(4));
        NaryTreePostorderTraversal naryTreePostorderTraversal = new NaryTreePostorderTraversal();
        System.out.println(naryTreePostorderTraversal.postorder(root));
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

        if (root.children != null)
            for (Node node : root.children)
                dfs(node);

        result.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        dfs(root);
        return result;
    }

}
