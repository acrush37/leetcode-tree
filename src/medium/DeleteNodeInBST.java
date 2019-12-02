package medium;

/*
    Given a root node reference of a BST and a key, delete the node with the given key in the BST.

    Return the root node reference (possibly updated) of the BST.
 */
public class DeleteNodeInBST {

    public static void main(String... args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        DeleteNodeInBST deleteNodeInBST = new DeleteNodeInBST();
        System.out.println(deleteNodeInBST.deleteNode(root, 3));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        TreeNode node = root.right;
        while (node.left != null) node = node.left;
        node.left = root.left;
        return root.right;
    }

}
