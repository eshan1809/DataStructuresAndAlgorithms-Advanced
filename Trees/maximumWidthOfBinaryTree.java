/*
1. Given the root of a binary tree, return the maximum width of the given tree.
2. The maximum width of a tree is the maximum width among all levels.
3. The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.
*/

import java.util.*;

public class maximumWidthOfBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Pair {
        TreeNode root = null;
        int index = 0;

        Pair(TreeNode root, int index) {
            this.root = root;
            this.index = index;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0, min = 0, max = 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.remove();
                if (i == 0)
                    min = p.index;
                if (i == size - 1)
                    max = p.index;
                if (p.root.left != null)
                    q.add(new Pair(p.root.left, 2 * p.index));
                if (p.root.right != null)
                    q.add(new Pair(p.root.right, 2 * p.index + 1));
            }
            maxWidth = Math.max(maxWidth, max - min + 1);
        }
        return maxWidth;
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

    public static int idx = 0;

    private static TreeNode deserialize(String[] arr) {
        if (idx >= arr.length || arr[idx].equals("null")) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserialize(arr);
        node.right = deserialize(arr);

        return node;
    }

    public static TreeNode deserialize(String str) {
        String[] arr = str.split(" ");
        return deserialize(arr);
    }

    public static void solve() {
        String str = scn.nextLine();
        TreeNode root = deserialize(str);

        int ans = widthOfBinaryTree(root);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}