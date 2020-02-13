package medium;

/*
    Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
    In one move, we may choose two adjacent nodes and move one coin from one node to another.
    (The move may be from parent to child, or from child to parent.)

    Return the number of moves required to make every node have exactly one coin.
 */
public class DistributeCoinsInBinaryTree {

    private int result;

    public static void main(String... args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        DistributeCoinsInBinaryTree distributeCoinsInBinaryTree = new DistributeCoinsInBinaryTree();
        System.out.println(distributeCoinsInBinaryTree.distributeCoins(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int dfs(TreeNode node) {

        if (node == null) return 0;
        int l = dfs(node.left), r = dfs(node.right);
        result += Math.abs(l) + Math.abs(r);
        return node.val + l + r - 1;
    }

    public int distributeCoins(TreeNode root) {

        dfs(root);
        return result;
    }

}
