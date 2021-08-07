/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from InOrder and LevelOrder Traversal.
3. you will be given two arrays representing a valid InOrder & LevelOrder of a Binary Tree. Program is required to create a unique Binary Tree.
*/

import java.util.*;

public class constructBinaryTreeFromInorderAndLevelorderTraversal {
    public static Scanner scn = new Scanner(System.in);

    static class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] levelOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        TreeNode root = null;
        for (int i = 0; i < levelOrder.length; i++) {
            if (i == 0)
                root = new TreeNode(levelOrder[i]);
            else
                helper(root, map, levelOrder[i]);
        }
        return root;
    }

    public static void helper(TreeNode root, Map<Integer, Integer> map, int add) {
        if (root == null)
            return;
        if (map.get(root.val) > map.get(add)) {
            if (root.left == null)
                root.left = new TreeNode(add);
            else
                helper(root.left, map, add);
        } else {
            if (root.right == null)
                root.right = new TreeNode(add);
            else
                helper(root.right, map, add);
        }
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

        int[] InOrder = new int[n];
        for (int i = 0; i < n; i++)
            InOrder[i] = scn.nextInt();

        int[] LevelOrder = new int[n];
        for (int i = 0; i < n; i++)
            LevelOrder[i] = scn.nextInt();

        TreeNode root = buildTree(InOrder, LevelOrder);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }

}
