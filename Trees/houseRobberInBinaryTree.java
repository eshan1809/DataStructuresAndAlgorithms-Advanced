/*
1. You are given a partially written function to solve.
2. The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.
Determine the maximum amount of money the thief can rob tonight without alerting the police.
3. Input and Output is managed for you.
*/

import java.util.Scanner;

public class houseRobberInBinaryTree {
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
        int sit, not;

        Pair(int a, int b) {
            sit = a;
            not = b;
        }
    }

    public static Pair helper(TreeNode root) {
        if (root == null)
            return new Pair(0, 0);
        Pair left = helper(root.left), right = helper(root.right);
        return new Pair(left.not + right.not + root.val, Math.max(left.sit, left.not) + Math.max(right.sit, right.not));
    }

    public static int HouseRobber(TreeNode root) {
        Pair p = helper(root);
        return Math.max(p.sit, p.not);
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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
