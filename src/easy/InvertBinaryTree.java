package easy;

/*
    Invert a binary tree.
 */
public class InvertBinaryTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        System.out.println(invertBinaryTree.invertTree(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root) {

        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        dfs(root.left);
        dfs(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

}
