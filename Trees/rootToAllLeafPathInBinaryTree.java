/*
Given a Binary Tree, return Root to all leaf path of binary tree
*/

import java.util.*;

public class rootToAllLeafPathInBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
        // write your code.
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if (root == null)
            return list;
        if (root.left == null && root.right == null) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(root.val);
            list.add(al);
            return list;
        }

        ArrayList<ArrayList<Integer>> l1 = rootToAllLeafPath(root.left);
        for (ArrayList<Integer> al : l1) {
            al.add(0, root.val);
            list.add(new ArrayList<>(al));
        }

        ArrayList<ArrayList<Integer>> l2 = rootToAllLeafPath(root.right);

        for (ArrayList<Integer> al : l2) {
            al.add(0, root.val);
            list.add(new ArrayList<>(al));
        }

        return list;
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

        ArrayList<ArrayList<Integer>> ans = rootToAllLeafPath(root);
        if (ans.size() == 0)
            System.out.println();
        for (ArrayList<Integer> al : ans) {
            for (Integer ele : al)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
