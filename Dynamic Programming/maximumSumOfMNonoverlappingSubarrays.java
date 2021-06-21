/*
1. You are given an array(arr) of positive numbers and two numbers M and K.
2. You have to find the maximum sum of M non-overlapping subarrays of size K.
3. The size of the given array(arr) is greater than M*K.
*/

import java.io.*;
import java.util.*;

public class maximumSumOfMNonoverlappingSubarrays {

    public static int helper(int[] arr, int idx, int m, int k) {

        return 0;
    }

    public static int solution(int[] arr, int m, int k) {
        // write your code here
        int[] pSum = new int[n];
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i];
        psum[0] = sum;
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            pSum[i] = sum;
        }
        return helper(arr, 0, m, k);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(arr, m, k));
    }
}
