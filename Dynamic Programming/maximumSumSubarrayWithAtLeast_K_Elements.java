/*
1. You are given an array(arr) of integers and a number k.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least k elements.
*/

import java.io.*;
import java.util.*;

public class maximumSumSubarrayWithAtLeast_K_Elements {
    public static int solution(int[] arr, int k) {
        // write your code here

        return 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }
}
