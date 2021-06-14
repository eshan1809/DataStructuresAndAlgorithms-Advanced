/*
1. Given a Binary Tree, print Vertical Order of it. 
2. For more Information watch given video link below.
*/

import java.util.*;

public class verticalOrderTraversalOfABinarytree {
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
        TreeNode node;
        int angle;

        Pair(TreeNode node, int angle) {
            this.node = node;
            this.angle = angle;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));

        while (q.size() > 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Pair p = q.remove();
                if (!map.containsKey(p.angle)) {
                    ArrayList<Integer> al = new ArrayList<>();
                    map.put(p.angle, al);
                }
                map.get(p.angle).add(p.node.val);
                min = Math.min(min, p.angle);
                max = Math.max(max, p.angle);
                if (p.node.left != null)
                    q.add(new Pair(p.node.left, p.angle - 1));
                if (p.node.right != null)
                    q.add(new Pair(p.node.right, p.angle + 1));
            }
        }

        for (int i = min; i <= max; i++)
            if (map.containsKey(i))
                list.add(map.get(i));
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
        scn.close();
    }
}
