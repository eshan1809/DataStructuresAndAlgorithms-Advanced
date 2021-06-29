/*
1. Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
2. An integer a is closer to x than an integer b if:
        |a - x| < |b - x|, or
        |a - x| == |b - x| and a < b
*/

import java.util.*;

public class findKClosestElements {
    static int X;

    static class Pair implements Comparable<Pair> {
        int val;

        Pair(int val) {
            this.val = val;
        }

        public int compareTo(Pair o) {
            int a = Math.abs(this.val - X), b = Math.abs(o.val - X);
            if (a == b)
                return this.val - o.val;
            return a - b;
        }
    }

    /* find 'k' closest element to 'x' and return answer list */
    /* elements in answer list should be in ascending order */
    public static ArrayList<Integer> findClosest(int[] arr, int k, int x) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        X = x;
        for (int i : arr)
            pq.add(new Pair(i));
        while (k-- > 0)
            list.add(pq.remove().val);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {

        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();
        scn.close();

        ArrayList<Integer> ans = findClosest(arr, k, x);

        for (int val : ans) {
            System.out.print(val + " ");
        }

    }
}