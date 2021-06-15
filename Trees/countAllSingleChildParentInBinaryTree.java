/*
1. Given a Binary Tree, return count all single child parent of binary tree
2. You are not count allowed to use any static or global variable.
*/

import java.util.*;

public class countAllSingleChildParentInBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void helper(TreeNode root, int[] ans) {
        if (root == null)
            return;
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null))
            ans[0]++;
        helper(root.left, ans);
        helper(root.right, ans);
    }

    public static int countExactlyOneChild(TreeNode root) {
        int[] ans = new int[1];
        helper(root, ans);
        return ans[0];
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
        Treenode.left = createTree(arr, IDX);
        Treenode.right = createTree(arr, IDX);

        return Treenode;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        System.out.println(countExactlyOneChild(root));
    }

    public static void main(String[] args) {
        solve();
    }
}