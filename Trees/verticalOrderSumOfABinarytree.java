/*
Given a Binary Tree, print Vertical Order Sum of it. 
*/

import java.util.*;

public class verticalOrderSumOfABinarytree {
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

    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        while (q.size() > 0) {
            int n = q.size();
            while (n-- > 0) {
                Pair rem = q.remove();
                if (rem.node.left != null)
                    q.add(new Pair(rem.node.left, rem.angle - 1));
                if (rem.node.right != null)
                    q.add(new Pair(rem.node.right, rem.angle + 1));
                map.put(rem.angle, map.getOrDefault(rem.angle, 0) + rem.node.val);
                min = Math.min(min, rem.angle);
                max = Math.max(max, rem.angle);
            }
        }
        for (int i = min; i <= max; i++)
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

        ArrayList<Integer> ans = verticalOrderSum(root);
        for (Integer j : ans)
            System.out.println(j);

    }

    public static void main(String[] args) {
        solve();
    }
}
