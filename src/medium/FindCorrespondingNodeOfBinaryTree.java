package medium;

/*
    Given two binary trees original and cloned and given a reference to a node target in the original tree.

    The cloned tree is a copy of the original tree.

    Return a reference to the same node in the cloned tree.
 */
public class FindCorrespondingNodeOfBinaryTree {

    private TreeNode result;

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode original, TreeNode cloned, TreeNode target) {

        if (original == target) {
            result = cloned;
            return;
        }

        if (original.left != null) {
            dfs(original.left, cloned.left, target);
            if (result != null) return;
        }

        if (original.right != null) dfs(original.right, cloned.right, target);
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        dfs(original, cloned, target);
        return result;
    }

}
