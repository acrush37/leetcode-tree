package medium;

import java.util.HashSet;
import java.util.Set;

/*
    Given a binary tree with the following rules: root.val == 0
    If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
    If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
    Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

    You need to first recover the binary tree and then implement the FindElements class:

    FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
    bool find(int target) Return if the target value exists in the recovered binary tree.
 */
public class FindElementsInContaminatedBinaryTree {

    private Set<Integer> t = new HashSet<>();

    public static void main(String... args) {

        FindElementsInContaminatedBinaryTree findElementsInContaminatedBinaryTree = new FindElementsInContaminatedBinaryTree();
        System.out.println(findElementsInContaminatedBinaryTree);
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public FindElementsInContaminatedBinaryTree(TreeNode root) {
        dfs(0, root);
    }

    private void dfs(int val, TreeNode root) {

        t.add(val);
        val = 1 + (val << 1);
        if (root.left != null) dfs(val, root.left);
        if (root.right != null) dfs(1 + val, root.right);
    }

    public boolean find(int target) {
        return t.contains(target);
    }

}
