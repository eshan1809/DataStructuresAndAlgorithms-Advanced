/*
1. Given an array A[] of size N. 
2. Find the number of pairs (i, j) such that A[i] XOR A[j] = 0, and 1 <= i < j <= N.
*/

import java.util.*;

public class countZerosXorPairs {

    public static int countPairs(int[] arr) {
        // write your code here
        int ans = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            max = Math.max(max, map.get(i));
        }
        int[] sum = new int[max + 1];
        for (int i = 1; i < max + 1; i++)
            sum[i] = i + sum[i - 1];
        for (int i : map.keySet())
            ans += sum[map.get(i) - 1];
        return ans;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(countPairs(arr));
    }
}