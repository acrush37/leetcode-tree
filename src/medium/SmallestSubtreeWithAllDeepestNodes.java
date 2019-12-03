package medium;

import java.util.*;

/*
    Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.

    A node is deepest if it has the largest depth possible among any node in the entire tree.

    The subtree of a node is that node, plus the set of all descendants of that node.

    Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
 */
public class SmallestSubtreeWithAllDeepestNodes {

    private int max;

    private List<TreeNode> t = new ArrayList<>();

    private Map<TreeNode, TreeNode> m = new HashMap<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        SmallestSubtreeWithAllDeepestNodes smallestSubtreeWithAllDeepestNodes = new SmallestSubtreeWithAllDeepestNodes();
        System.out.println(smallestSubtreeWithAllDeepestNodes.subtreeWithAllDeepest(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(int k, TreeNode root) {

        if (k == max) t.add(root);
        else if (k > max) {
            max = k;
            t = new ArrayList<>();
            t.add(root);
        }

        if (root.left != null) {
            m.put(root.left, root);
            dfs(k+1, root.left);
        }

        if (root.right != null) {
            m.put(root.right, root);
            dfs(k+1, root.right);
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        dfs(0, root);
        int n = t.size();

        while (true) {

            boolean flag = true;
            TreeNode node = t.get(0);

            for (int i = 0; i < n; i++)
                if (!node.equals(t.get(i))) {
                    flag = false;
                    break;
                }

            if (flag) return node;
            for (int i = 0; i < n; i++) t.set(i, m.get(t.get(i)));
        }
    }

}
