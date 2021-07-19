/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given LevelOrder Traversal.
3. you will be given an array representing a valid LevelOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
*/

import java.util.*;

public class constructBSTfromLevelorderTraversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        TreeNode parent;
        int lb, rb;

        Pair(TreeNode parent, int lb, int rb) {
            this.parent = parent;
            this.lb = lb;
            this.rb = rb;
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        TreeNode root = null;
        Queue<Pair> q = new ArrayDeque<>();
        int i = 0;
        q.add(new Pair(null, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while (!q.isEmpty() && i < LevelOrder.length) {
            Pair rem = q.remove();
            if (rem.parent == null) {
                root = new TreeNode(LevelOrder[i++]);
                q.add(new Pair(root, rem.lb, root.val));
                q.add(new Pair(root, root.val, rem.rb));
            } else {
                if (LevelOrder[i] < rem.parent.val && LevelOrder[i] > rem.lb) {
                    TreeNode node = new TreeNode(LevelOrder[i++]);
                    rem.parent.left = node;
                    q.add(new Pair(node, rem.lb, node.val));
                    q.add(new Pair(node, node.val, rem.rb));
                } else if (LevelOrder[i] > rem.parent.val && LevelOrder[i] < rem.rb) {
                    TreeNode node = new TreeNode(LevelOrder[i++]);
                    rem.parent.right = node;
                    q.add(new Pair(node, rem.lb, node.val));
                    q.add(new Pair(node, node.val, rem.rb));
                }
            }
        }
        return root;
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
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}