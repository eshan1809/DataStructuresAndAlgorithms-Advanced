/*
1. Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
2. According to the definition of LCA on Wikipedia: 
The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has 
both p and q as descendants (where we allow a node to be a descendant of itself).
3. If LCA does not exist in the tree print null.
*/

import java.util.*;

public class lowestCommonAncestorOfABinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<TreeNode> nodeToRootPath(TreeNode root, int data) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null)
            return list;
        if (root.val == data) {
            list.add(root);
            return list;
        }

        List<TreeNode> l1 = nodeToRootPath(root.left, data);
        if (l1.size() > 0) {
            l1.add(0, root);
            return l1;
        }

        List<TreeNode> l2 = nodeToRootPath(root.right, data);
        if (l2.size() > 0) {
            l2.add(0, root);
            return l2;
        }
        return list;
    }

    public static TreeNode lowestCommonAncestor(TreeNode node, int p, int q) {
        List<TreeNode> l1 = nodeToRootPath(node, p), l2 = nodeToRootPath(node, q);
        for (int i = 0; i < Math.min(l1.size(), l2.size()); i++)
            if (l1.get(i) != l2.get(i))
                return l1.get(i - 1);
        int idx = Math.min(l1.size(), l2.size()) - 1;
        if (idx >= 0)
            return l1.get(idx);
        return null;
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

        int e1 = scn.nextInt();
        int e2 = scn.nextInt();

        TreeNode ans = lowestCommonAncestor(root, e1, e2);
        System.out.println(ans == null ? null : ans.val);
    }

    public static void main(String[] args) {
        solve();
    }
}