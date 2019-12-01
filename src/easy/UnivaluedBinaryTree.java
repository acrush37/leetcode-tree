package easy;

/*
    A binary tree is univalued if every node in the tree has the same value.

    Return true if and only if the given tree is univalued.
 */
public class UnivaluedBinaryTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        UnivaluedBinaryTree univaluedBinaryTree = new UnivaluedBinaryTree();
        System.out.println(univaluedBinaryTree.isUnivalTree(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean dfs(TreeNode root, int val) {
        if (root == null) return true;
        return root.val == val && dfs(root.left, val) && dfs(root.right, val);
    }

    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

}
