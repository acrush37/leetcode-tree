package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    A full binary tree is a binary tree where each node has exactly 0 or 2 children.

    Return a list of all possible full binary trees with N nodes.
    Each element of the answer is the root node of one possible tree.

    Each node of each tree in the answer must have node.val = 0.
 */
public class AllPossibleFullBinaryTrees {

    public static void main(String... args) {

        AllPossibleFullBinaryTrees allPossibleFullBinaryTrees = new AllPossibleFullBinaryTrees();
        System.out.println(allPossibleFullBinaryTrees.allPossibleFBT(7));
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> allPossibleFBT(int N) {

        if ((N & 1) == 0) return Collections.EMPTY_LIST;
        List<TreeNode> result = new ArrayList<>();
        if (N == 1) result.add(new TreeNode(0));

        for (int i = 1; i < N; i += 2) {

            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N-i-1);

            for (TreeNode l : left)
                for (TreeNode r : right) {

                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                    result.add(node);
                }
        }

        return result;
    }

}
