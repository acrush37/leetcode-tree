package easy;

/*
    Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 */
public class RangeSumOfBST {

    public static void main(String... args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        RangeSumOfBST rangeSumOfBST = new RangeSumOfBST();
        System.out.println(rangeSumOfBST.rangeSumBST(root, 7, 15));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {

        if (root == null) return 0;
        int value = root.val >= L && root.val <= R ? root.val : 0;
        return value + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

}
