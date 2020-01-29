package medium;

import java.util.*;

/*
    Given a binary tree, return all duplicate subtrees.
    For each kind of duplicate subtrees, you only need to return the root node of any one of them.

    Two trees are duplicate if they have the same structure with same node values.
 */
public class FindDuplicateSubtrees {

    private StringBuilder sb;

    private Map<String, Integer> m = new HashMap<>();

    private List<TreeNode> result = new ArrayList<>();

    public static void main(String... args) {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.right.left = new TreeNode(0);
        FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
        System.out.println(findDuplicateSubtrees.findDuplicateSubtrees(root));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode root) {

        if (root == null) return;
        sb.append(root.val);
        dfs(root.left);
        sb.append("[");
        dfs(root.right);
        sb.append("]");
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        if (root == null) return Collections.EMPTY_LIST;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();
            sb = new StringBuilder();
            dfs(node);
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
            String s = sb.toString();
            Integer count = m.get(s);

            if (count == null) m.put(s, 1);
            else {
                m.put(s, 1 + count);
                if (count == 1) result.add(node);
            }
        }

        return result;
    }

}
