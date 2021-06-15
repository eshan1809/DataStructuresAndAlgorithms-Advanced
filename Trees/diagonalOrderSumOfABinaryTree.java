/*
Given a Binary Tree, print Diagonal order sum of it. 
*/

import java.util.*;

public class diagonalOrderSumOfABinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (q.size() > 0) {
            int n = q.size(), sum = 0;
            while (n-- > 0) {
                TreeNode rem = q.remove();
                while (rem != null) {
                    sum += rem.val;
                    if (rem.left != null)
                        q.add(rem.left);
                    rem = rem.right;
                }
            }
            list.add(sum);
        }
        return list;
    }

    // input_section=================================================

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

        ArrayList<Integer> ans = diagonalOrderSum(root);
        for (Integer j : ans)
            System.out.print(j + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
