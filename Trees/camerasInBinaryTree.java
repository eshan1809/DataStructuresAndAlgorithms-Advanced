/*
1. You are given a partially written function to solve.
2. You are required to complete the body of MinCamerasInBT_ function. The function is expected to return integer value representing minimum number of camera(s) required for the coverage of complete tree.
3.A camera is placed on any node will ensure coverage of parent-node as well as it's child-node(s), if any.
4. Input and Output is managed for you.
*/

import java.util.Scanner;

public class camerasInBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int noc = 0;

    public static int MinCamerasInBT(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (helper(root) == 0)
            noc++;
        return noc;
    }

    public static int helper(TreeNode root) {
        if (root == null)
            return 1;
        if (root.left == null && root.right == null)
            return 0;
        int left = helper(root.left), right = helper(root.right);
        if (left == 0 || right == 0) {
            noc++;
            return 2;
        } else if (left == 2 || right == 2)
            return 1;
        else
            return 0;
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
        System.out.println(MinCamerasInBT(root));

    }

    public static void main(String[] args) {
        solve();
    }
}