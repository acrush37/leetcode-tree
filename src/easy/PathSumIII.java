package easy;

/*
    You are given a binary tree in which each node contains an integer value.

    Find the number of paths that sum to a given value.

    The path does not need to start or end at the root or a leaf, but it must go downwards
    (traveling only from parent nodes to child nodes).

    The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class PathSumIII {

    public static void main(String... args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum(root, 8));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int dfs(TreeNode root, int sum) {

        if (root == null) return 0;
        int s = sum - root.val;
        return dfs(root.left, s) + dfs(root.right, s) + (s == 0 ? 1 : 0);
    }

    public int pathSum(TreeNode root, int sum) {

        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

}
