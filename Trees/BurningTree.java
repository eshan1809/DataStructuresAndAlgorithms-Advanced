/*
1. Given a binary tree and target. 
2. Find the minimum time required to burn the complete binary tree if the target is set on fire. 
3. It is known that in 1 second all nodes connected to a given node get burned. That is, its left child, right child and parent.
*/

import java.util.*;

public class BurningTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int height(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static int ans;

    public static int burningTree(TreeNode root, int fireNode) {
        ans = 0;
        helper(root, fireNode);
        return ans;
    }

    public static int helper(TreeNode root, int fireNode) {
        if (root == null)
            return -1;

        if (root.val == fireNode) {
            ans = Math.max(height(root.left), height(root.right));
            return 0;
        }

        int left = helper(root.left, fireNode);
        if (left != -1) {
            ans = Math.max(ans, height(root.right) + 1 + left);
            return left + 1;
        }
        int right = helper(root.right, fireNode);
        if (right != -1) {
            ans = Math.max(ans, height(root.left) + 1 + right);
            return right + 1;
        }
        return -1;
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
        int fireNode = scn.nextInt();

        int ans = burningTree(root, fireNode);
        System.out.println(ans);

    }

    public static void main(String[] args) {
        solve();
    }
}