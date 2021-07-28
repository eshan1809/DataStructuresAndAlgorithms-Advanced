/*
1. Given the root of a binary tree.
2. The value of a target node target, and an integer k.
3. You have return an array of the values of all nodes that have a distance k from the target node.
*/

import java.util.*;

public class allNodesDistanceKInBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static void kDistDown(TreeNode root, int k, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (k == 0) {
            list.add(root.val);
            return;
        }
        kDistDown(root.left, k - 1, list);
        kDistDown(root.right, k - 1, list);
    }

    private static int find(TreeNode root, int target, int k, ArrayList<Integer> list) {
        if (root == null)
            return -1;
        if (root.val == target) {
            kDistDown(root, k, list);
            return k - 1;
        }
        int retL = find(root.left, target, k, list);
        if (retL != -1) {
            if (retL == 0)
                list.add(root.val);
            else
                kDistDown(root.right, retL - 1, list);
            return retL - 1;
        }
        int retR = find(root.right, target, k, list);
        if (retR != -1) {
            if (retR == 0)
                list.add(root.val);
            else
                kDistDown(root.left, retR - 1, list);
            return retR - 1;
        }
        return -1;
    }

    public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        find(root, target, k, list);
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
        int target = scn.nextInt();
        int k = scn.nextInt();

        ArrayList<Integer> ans = distanceK(root, target, k);
        if (ans.size() == 0)
            System.out.println();
        for (Integer ele : ans)
            System.out.println(ele + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}