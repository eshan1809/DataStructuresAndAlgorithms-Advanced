/*
Given an array of n distinct elements, find the minimum number of swaps required to sort the array.
*/

import java.io.*;
import java.util.*;

public class minimumNumberOfSwapsRequiredToSortAnArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        System.out.println(minSwaps(arr));
    }

    public static int minSwaps(int[] arr) {
        int n = arr.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++)
            pairs[i] = new Pair(arr[i], i);
        Arrays.sort(pairs);
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (pairs[i].idx != i) {
                Pair temp = pairs[pairs[i].idx];
                pairs[pairs[i].idx] = pairs[i];
                pairs[i] = temp;
                count++;
            }
        }
        return count;
    }

    private static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
}
