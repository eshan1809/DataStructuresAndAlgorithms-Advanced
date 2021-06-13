/*
1. Given a Binary Tree, return Width Of Binary Tree. 
2. For more detail watch the video.
*/

import java.util.*;

public class widthOfABinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void helper(TreeNode root, int angle, Set<Integer> set) {
        if (root == null)
            return;
        set.add(angle);
        helper(root.left, angle - 45, set);
        helper(root.right, angle + 45, set);
    }

    public static int width(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        helper(root, 0, set);
        return set.size();
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

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
        scn.close();
    }
}
