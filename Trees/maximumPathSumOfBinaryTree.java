/*
1. You are given a partially written function to solve.

2. You are required to complete the body of maxPathSum function. The function is expected to return Integer value depending upon node-to-node paths where path sum equals targetSum.

3. A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

4. The path sum of a path is the sum of the node's values in the path.
*/

import java.util.Scanner;

public class maximumPathSumOfBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int helper(TreeNode root, int[] max) {
        if (root == null)
            return 0;
        int left = helper(root.left, max), right = helper(root.right, max);
        max[0] = Math.max(max[0], root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0));
        int ans = Math.max(left, right);
        return root.val + (ans > 0 ? ans : 0);
    }

    public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(root, max);
        return max[0];
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