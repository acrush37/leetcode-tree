package medium;

/*
    Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST.
    Return the root node of the BST after the insertion.
    It is guaranteed that the new value does not exist in the original BST.

    Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
    You can return any of them.
 */
public class InsertIntoBinarySearchTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        InsertIntoBinarySearchTree insertIntoBinarySearchTree = new InsertIntoBinarySearchTree();
        System.out.println(insertIntoBinarySearchTree.insertIntoBST(root, 5));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        if (root.val > val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);

        return root;
    }

}
