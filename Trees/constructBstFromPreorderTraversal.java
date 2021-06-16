/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given PreOrder Traversal.
3. you will be given an array representing a valid PreOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
*/

import java.util.Scanner;

public class constructBstFromPreorderTraversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode helper(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = helper(root.left, val);
        else if (val > root.val)
            root.right = helper(root.right, val);
        else
            root.left = helper(root.left, val);
        return root;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int i : preorder)
            root = helper(root, i);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}