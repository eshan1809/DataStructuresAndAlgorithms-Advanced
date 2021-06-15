/*
Given a Binary Tree, return list of all single child parent of binary tree
*/

import java.util.*;

public class allSingleChildParentInBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void helper(TreeNode root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null))
            ans.add(root.val);
        helper(root.left, ans);
        helper(root.right, ans);
    }

    public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
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

        ArrayList<Integer> ans = exactlyOneChild(root);
        if (ans.size() == 0)
            System.out.println();
        for (Integer ele : ans)
            System.out.print(ele + " ");
    }

    public static void main(String[] args) {
        solve();
    }
}