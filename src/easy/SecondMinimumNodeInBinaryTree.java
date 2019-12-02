package easy;

/*
    Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node.
    If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
    More formally, the property root.val = min(root.left.val, root.right.val) always holds.

    Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

    If no such second minimum value exists, output -1 instead.
 */
public class SecondMinimumNodeInBinaryTree {

    private Integer first, second;

    public static void main(String... args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        SecondMinimumNodeInBinaryTree secondMinimumNodeInBinaryTree = new SecondMinimumNodeInBinaryTree();
        System.out.println(secondMinimumNodeInBinaryTree.findSecondMinimumValue(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root) {

        if (root == null) return;

        if (root.val < first) {
            second = first;
            first = root.val;
        } else if (root.val > first && (second == null || root.val < second)) second = root.val;

        dfs(root.left);
        dfs(root.right);
    }

    public int findSecondMinimumValue(TreeNode root) {

        first = root.val;
        dfs(root);
        return second == null ? -1 : second;
    }

}
