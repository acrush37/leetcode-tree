package medium;

/*
    Given a binary tree root and a linked list with head as the first node.

    Return True if all the elements in the linked list starting from the head correspond
    to some downward path connected in the binary tree otherwise return False.

    In this context downward path means a path that starts at some node and goes downwards.
 */
public class LinkedListInBinaryTree {

    public static void main(String... args) {

        LinkedListInBinaryTree linkedListInBinaryTree = new LinkedListInBinaryTree();
        System.out.println(linkedListInBinaryTree.isSubPath(null, null));
    }

    static class ListNode {

        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean dfs(TreeNode root, ListNode head) {

        if (head == null) return true;
        if (root == null || root.val != head.val) return false;
        return dfs(root.left, head.next) || dfs(root.right, head.next);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {

        if (root == null) return false;
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

}
