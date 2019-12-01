package easy;

/*
    Given the root node of a binary search tree (BST) and a value.
    You need to find the node in the BST that the node's value equals the given value.
    Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 */
public class SearchInBinarySearchTree {

    public static void main(String... args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        SearchInBinarySearchTree searchInBinarySearchTree = new SearchInBinarySearchTree();
        System.out.println(searchInBinarySearchTree.searchBST(root, 2));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;
        if (root.val == val) return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

}
