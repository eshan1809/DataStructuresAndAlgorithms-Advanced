/*
1. You are given a partially written function to solve.
2. You are required to complete the body of maxPathSum function. The function is expected to return Integer value depending upon leaf-to-leaf paths where path sum equals targetSum.
3. Input and Output is managed for you.
*/

import java.util.Scanner;

public class maximumPathSumInBetweenTwoLeavesOfBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int max;

    public static int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left), right = helper(root.right);
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public static int maxPathSum(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    // input_Section=================================================

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
        System.out.println(maxPathSum(root));
    }

    public static void main(String[] args) {
        solve();
    }
}