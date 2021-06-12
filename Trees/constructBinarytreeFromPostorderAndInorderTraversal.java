/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from PostOrder and InOrder Traversal.
3. you will be given two arrays representing a valid PostOrder & InOrder of a Binary Tree. Program is required to create a unique Binary Tree.
*/

import java.util.Scanner;

public class constructBinarytreeFromPostorderAndInorderTraversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode helper(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postStart < 0 || inStart < inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        int index = inStart;
        for (; index >= inEnd; index--)
            if (inorder[index] == root.val)
                break;
        root.right = helper(postStart - 1, inStart, index + 1, postorder, inorder);
        root.left = helper(postStart - 1 + index - inStart, index - 1, inEnd, postorder, inorder);
        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, inorder.length - 1, 0, postorder, inorder);
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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
