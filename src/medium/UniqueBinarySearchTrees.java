package medium;

/*
    Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 */
public class UniqueBinarySearchTrees {

    public static void main(String... args) {

        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(3));
    }

    public int numTrees(int n) {

        int[] f = new int[n+1];
        f[0] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                f[i] += f[j] * f[i-j-1];

        return f[n];
    }

}
