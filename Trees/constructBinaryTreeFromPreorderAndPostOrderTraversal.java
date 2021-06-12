/*
1. You are given a partially written function to solve.
2. you will be given two arrays representing a valid PreOrder & PostOrder of a Binary Tree. Program is required to create a unique Binary Tree.
*/

import java.util.*;

public class constructBinaryTreeFromPreorderAndPostOrderTraversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode helper(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd,
            Map<Integer, Integer> map) {
        if (preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd)
            return root;
        int idx = map.get(pre[preStart + 1]);
        root.left = helper(pre, post, preStart + 1, preStart + (idx - postStart + 1), postStart, idx, map);
        root.right = helper(pre, post, preStart + (idx - postStart) + 2, preEnd, idx + 1, postEnd - 1, map);

        return root;
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++)
            map.put(post[i], i);
        return helper(pre, post, 0, pre.length - 1, 0, post.length - 1, map);
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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
