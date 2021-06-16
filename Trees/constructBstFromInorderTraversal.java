/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given InOrder Traversal.
3. you will be given an array representing a valid InOrder of a Binary Search Tree. Program is required to create a unique Balanced Binary Search Tree.
*/

import java.util.Scanner;

public class constructBstFromInorderTraversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode helper(int[] inOrder, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(inOrder[mid]);
        root.left = helper(inOrder, start, mid - 1);
        root.right = helper(inOrder, mid + 1, end);
        return root;
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {
        TreeNode root = helper(inOrder, 0, inOrder.length - 1);
        return root;
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

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = constructFromInOrder(in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}