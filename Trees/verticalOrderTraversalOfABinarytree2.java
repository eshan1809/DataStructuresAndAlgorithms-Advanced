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

    public static class Pair implements Comparable<Pair> {
        TreeNode node;
        int angle;

        Pair(TreeNode node, int angle) {
            this.node = node;
            this.angle = angle;
        }

        public int compareTo(Pair o) {
            if (this.node.val != o.node.val)
                return this.node.val - o.node.val;
            return this.angle - o.angle;
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
            PriorityQueue<Pair> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                Pair p = q.remove();
                pq.add(p);
                if (p.node.left != null)
                    q.add(new Pair(p.node.left, p.angle - 1));
                if (p.node.right != null)
                    q.add(new Pair(p.node.right, p.angle + 1));
            }

            while (pq.size() > 0) {
                Pair p = pq.remove();
                if (!map.containsKey(p.angle))
                    map.put(p.angle, new ArrayList<>());
                map.get(p.angle).add(p.node.val);
                min = Math.min(min, p.angle);
                max = Math.max(max, p.angle);
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
    }
}
