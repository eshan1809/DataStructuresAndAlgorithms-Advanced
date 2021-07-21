/*
1. You are given a partially written function to solve.
2. You are required to complete the body of PathSum function. The function is expected to return all root-to-leaf paths where each path's sum equals targetSum.
3. Input and Output is managed for you.
*/

import java.util.*;

public class pathSumInBinaryTree2 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static void helper(TreeNode root, int ssf, int targetSum, ArrayList<ArrayList<Integer>> list,
            ArrayList<Integer> al) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (ssf + root.val == targetSum) {
                al.add(root.val);
                list.add(new ArrayList<>(al));
                al.remove(al.size() - 1);
            }
            return;
        }

        al.add(root.val);
        helper(root.left, ssf + root.val, targetSum, list, al);
        helper(root.right, ssf + root.val, targetSum, list, al);
        al.remove(al.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        helper(root, 0, targetSum, list, new ArrayList<>());
        return list;
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
        int tar = scn.nextInt();
        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        ArrayList<ArrayList<Integer>> ans = pathSum(root, tar);
        for (ArrayList<Integer> ar : ans) {
            for (Integer ele : ar) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}