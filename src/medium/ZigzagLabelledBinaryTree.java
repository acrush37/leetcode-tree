package medium;

import java.util.ArrayList;
import java.util.List;

/*
    In an infinite binary tree where every node has two children, the nodes are labelled in row order.

    In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right,
    while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.

    Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
 */
public class ZigzagLabelledBinaryTree {

    public static void main(String... args) {

        ZigzagLabelledBinaryTree zigzagLabelledBinaryTree = new ZigzagLabelledBinaryTree();
        System.out.println(zigzagLabelledBinaryTree.pathInZigZagTree(8));
    }

    public List<Integer> pathInZigZagTree(int label) {

        List<Integer> result = new ArrayList<>();
        int k = 0, n = (int) (Math.log(label) / Math.log(2)), m = 1 << (n+1);
        int[] f = new int[m], p = new int[m];

        for (int i = 0; i <= n; i++) {

            int x = 1 << i, y = x << 1;

            if ((i & 1) == 0) for (int j = x; j < y; j++) f[++k] = j;
            else for (int j = y-1; j >= x; j--) f[++k] = j;
        }

        for (int i = m-1; i > 1; i--) p[f[i]] = f[i>>1];

        while (label != 0) {
            result.add(0, label);
            label = p[label];
        }

        return result;
    }

}
