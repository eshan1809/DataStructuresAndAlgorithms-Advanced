/*
Given a Binary Tree, return root To Node path of it. 
*/

import java.util.*;

public class nodeToRootPathBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, int data) {
        // write your code here
        ArrayList<TreeNode> list = new ArrayList<>();
        if (root == null)
            return list;
        if (root.val == data) {
            list.add(root);
            return list;
        }

        ArrayList<TreeNode> l1 = nodeToRootPath(root.left, data);
        if (l1.size() > 0) {
            l1.add(root);
            return l1;
        }

        ArrayList<TreeNode> l2 = nodeToRootPath(root.right, data);
        if (l2.size() > 0) {
            l2.add(root);
            return l2;
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

        int data = scn.nextInt();
        ArrayList<TreeNode> ans = nodeToRootPath(root, data);
        if (ans.size() == 0)
            System.out.println();
        for (TreeNode node : ans)
            System.out.print(node.val + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}