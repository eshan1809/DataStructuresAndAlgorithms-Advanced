/*
1. You are given four arrays(A1,A2,A3,A4) of integers. All arrays are of same length(N).
2. You have to find the count of all unique quadruplets(a,b,c,d) such that - 
   A1[a] + A2[b] + A3[c] + A4[d] = 0.
*/

import java.util.*;

public class quadrupletSum2 {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A)
            for (int j : B)
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
        int count = 0;
        for (int i : C)
            for (int j : D)
                count += map.getOrDefault(-i - j, 0);
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int[] arr4 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr3[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr4[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(fourSumCount(arr1, arr2, arr3, arr4));
    }
}
