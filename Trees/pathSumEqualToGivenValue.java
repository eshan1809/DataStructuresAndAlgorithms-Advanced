/*
1. Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
2. The path does not need to start or end at the root or a leaf,path can start from any where but it must go downwards
*/

import java.util.*;

public class pathSumEqualToGivenValue {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int count;

    public static int pathSum(TreeNode root, int K) {
        count = 0;
        helper(root, K);
        return count;
    }

    public static void helper(TreeNode root, int K) {
        if (root == null)
            return;
        helper2(root.left, K - root.val);
        helper2(root.right, K - root.val);
        helper(root.left, K);
        helper(root.right, K);
    }

    public static void helper2(TreeNode node, int K) {
        if (node == null)
            return;
        if (K == node.val)
            count++;
        helper2(node.left, K - node.val);
        helper2(node.right, K - node.val);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);
    }

    public static int idx = 0;

    private static TreeNode deserialize(String[] arr) {
        if (idx >= arr.length || arr[idx].equals("null")) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserialize(arr);
        node.right = deserialize(arr);

        return node;
    }

    public static TreeNode deserialize(String str) {
        String[] arr = str.split(" ");
        return deserialize(arr);
    }

    public static void solve() {
        String str = scn.nextLine();
        TreeNode root = deserialize(str);
        int tar = scn.nextInt();

        int ans = pathSum(root, tar);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}