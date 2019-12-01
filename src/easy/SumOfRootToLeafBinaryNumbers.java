package easy;

/*
    Given a binary tree, each node has value 0 or 1.
    Each root-to-leaf path represents a binary number starting with the most significant bit.
    For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

    For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

    Return the sum of these numbers.
 */
public class SumOfRootToLeafBinaryNumbers {

    private int result;

    public static void main(String... args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        SumOfRootToLeafBinaryNumbers sumOfRootToLeafBinaryNumbers = new SumOfRootToLeafBinaryNumbers();
        System.out.println(sumOfRootToLeafBinaryNumbers.sumRootToLeaf(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root, String s) {

        if (root.left != null && root.right == null) dfs(root.left, s + root.val);
        else if (root.left == null && root.right != null) dfs(root.right,s + root.val);
        else if (root.left != null && root.right != null) {
            dfs(root.left, s + root.val);
            dfs(root.right,s + root.val);
        } else {
            char[] c = (s + root.val).toCharArray();
            int n = c.length;
            for (int i = 0; i < n; i++) result += (int) Math.pow(2, n-i-1) * (c[i] - 48);
        }
    }

    public int sumRootToLeaf(TreeNode root) {

        if (root == null) return 0;
        dfs(root,"");
        return result;
    }

}
