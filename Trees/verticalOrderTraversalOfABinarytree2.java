/*
1. Given a Binary Tree, print Vertical Order of it. 
2. For each node at position (row, col), its left and right 
   children will be at positions (row + 1, col - 1) and (row + 1, col + 1) 
   respectively. The root of the tree is at (0, 0).
3. The vertical order traversal of a binary tree is a list of top-to-bottom 
   orderings for each column index starting from the leftmost column and ending 
   on the rightmost column. There may be multiple nodes in the same row and same 
   column. In such a case, sort these nodes by their values.
*/

import java.util.*;

public class verticalOrderTraversalOfABinarytree2 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {

        return null;
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
