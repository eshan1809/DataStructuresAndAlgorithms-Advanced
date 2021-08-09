/*
1. Given a binary tree and target. 
2. Find the minimum time required to burn the complete binary tree if the target is set on fire. 
3. It is known that in 1 second all nodes connected to a given node get burned. That is, its left child, right child and parent.
*/

import java.util.*;

public class burningTree2 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode parent = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static void setParent(TreeNode root, TreeNode parent) {
        if (root == null)
            return;
        root.parent = parent;
        setParent(root.left, root);
        setParent(root.right, root);
    }

    private static TreeNode find(TreeNode root, int fireNode) {
        if (root == null || root.val == fireNode)
            return root;
        TreeNode left = find(root.left, fireNode);
        if (left != null)
            return left;
        return find(root.right, fireNode);
    }

    public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int fireNode) {
        setParent(root, null);
        TreeNode burningNode = find(root, fireNode);
        return BFS(root, burningNode);
    }

    private static ArrayList<ArrayList<Integer>> BFS(TreeNode root, TreeNode burningNode) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(burningNode);
        while (!q.isEmpty()) {
            ArrayList<Integer> al = new ArrayList<>();
            int size = q.size();
            while (size-- > 0) {
                TreeNode rem = q.remove();
                if (set.contains(rem))
                    continue;
                set.add(rem);
                al.add(rem.val);
                if (rem.left != null && !set.contains(rem.left))
                    q.add(rem.left);
                if (rem.right != null && !set.contains(rem.right))
                    q.add(rem.right);
                if (rem.parent != null && !set.contains(rem.parent))
                    q.add(rem.parent);
            }
            list.add(al);
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
        int fireNode = scn.nextInt();

        ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
        if (ans.size() == 0)
            System.out.println();
        for (ArrayList<Integer> ar : ans) {
            for (Integer ele : ar)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}