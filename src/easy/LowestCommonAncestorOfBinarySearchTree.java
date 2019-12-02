package easy;

/*
    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 */
public class LowestCommonAncestorOfBinarySearchTree {

    public static void main(String... args) {

        LowestCommonAncestorOfBinarySearchTree lowestCommonAncestorOfBinarySearchTree = new LowestCommonAncestorOfBinarySearchTree();
        System.out.println(lowestCommonAncestorOfBinarySearchTree.lowestCommonAncestor(null,null, null));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

}
