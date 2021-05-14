/*
1. You are given an array(arr1) of integers and an integer k.
2. Another array(arr2) is formed by concatenating K copies of arr1.
   For example, if arr1 = {1,2} and k = 3, then arr2 = {1,2,1,2,1,2}.
3. You have to find the maximum subarray sum in arr2.
*/

import java.io.*;
import java.util.*;

public class K_Concatenation {
    public static long solution(int[] arr, int k, long sum) {
        // write your code here
        int curr = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr = Math.max(curr + arr[i], arr[i]);
            max = Math.max(max, curr);
        }
        if (k == 1)
            return max;
        for (int i = 0; i < arr.length; i++) {
            curr = Math.max(curr + arr[i], arr[i]);
            max = Math.max(max, curr);
        }
        if (sum < 0)
            return max;
        else
            return max + sum * (k - 2);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k, sum));
    }
}
