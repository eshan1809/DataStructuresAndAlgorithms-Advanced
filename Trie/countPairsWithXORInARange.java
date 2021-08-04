/*
Given an integer array nums and two integers low and high.
Count number of pairs of indexes (i, j) for which both of this expression's are satisfied:
1. 0 <= i < j < nums.length
2. low <= nums[i] ^ nums[j] <= high
*/

import java.io.*;

public class countPairsWithXORInARange {
    static class Node {
        Node left, right;
        int count;
    }

    static Node root;
    static int MAX_BIT = 14;

    public static void insert(int val) {
        int bitIdx = MAX_BIT;
        Node curr = root;
        while (bitIdx >= 0) {
            int x = (val & (1 << bitIdx)) > 0 ? 1 : 0;
            if (x == 1) {
                if (curr.right == null)
                    curr.right = new Node();
                curr = curr.right;
            } else {
                if (curr.left == null)
                    curr.left = new Node();
                curr = curr.left;
            }
            curr.count++;
            bitIdx--;
        }
    }

    public static int getCount(Node curr) {
        return curr == null ? 0 : curr.count;
    }

    public static int query(Node curr, int limit, int val, int idx) {
        if (curr == null)
            return 0;
        if (idx < 0)
            return getCount(curr);
        int x = (val & (1 << idx)) > 0 ? 1 : 0, lx = (limit & (1 << idx)) > 0 ? 1 : 0, ans = 0;
        if (x == 0) {
            if (lx == 0)
                return query(curr.left, limit, val, idx - 1);
            else
                return getCount(curr.left) + query(curr.right, limit, val, idx - 1);
        } else {
            if (lx == 0)
                return query(curr.right, limit, val, idx - 1);
            else
                return query(curr.left, limit, val, idx - 1) + getCount(curr.right);
        }
    }

    public static int countPairs(int[] nums, int low, int high) {
        root = new Node();
        int count = 0;
        for (int val : nums) {
            count += query(root, high, val, MAX_BIT) - query(root, low - 1, val, MAX_BIT);
            insert(val);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(read.readLine());
        }
        int low = Integer.parseInt(read.readLine());
        int high = Integer.parseInt(read.readLine());

        int result = countPairs(nums, low, high);
        System.out.println(result);

    }
}
