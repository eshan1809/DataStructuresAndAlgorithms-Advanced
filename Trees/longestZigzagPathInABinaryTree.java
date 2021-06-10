/*
1. You are given a partially written function to solve.
2. Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
    a. Choose any node in the binary tree and a direction (right or left).
    b. If the current direction is right then move to the right child of the current node otherwise move to the left child.
    c. Change the direction from right to left or right to left.
    d. Repeat the second and third step until you can't move in the tree.

3.Zigzag length is defined in terms of edges. (A single node has a length of 0).
4. Return the longest ZigZag path contained in that tree.
*/

import java.util.Scanner;

public class longestZigzagPathInABinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Pair {
        int lans, rans;

        Pair(int a, int b) {
            lans = a;
            rans = b;
        }
    }

    static int ans = 0;

    public static Pair helper(TreeNode root) {
        if (root == null)
            return new Pair(-1, -1);
        Pair pl = helper(root.left), pr = helper(root.right);
        Pair p = new Pair(pl.rans + 1, pr.lans + 1);
        ans = Math.max(ans, Math.max(p.lans, p.rans));
        return p;
    }

    public static int longestZigZagPath(TreeNode root) {
        helper(root);
        return ans;
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
