package easy;

/*
    Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original
    BST is changed to the original key plus sum of all keys greater than the original key in BST.
 */
public class ConvertBSTToGreaterTree {

    private int sum;

    public static void main(String... args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        ConvertBSTToGreaterTree convertBSTToGreaterTree = new ConvertBSTToGreaterTree();
        System.out.println(convertBSTToGreaterTree.convertBST(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode convertBST(TreeNode root) {

        if (root == null) return null;
        convertBST(root.right);
        root.val = (sum += root.val);
        convertBST(root.left);
        return root;
    }

}
