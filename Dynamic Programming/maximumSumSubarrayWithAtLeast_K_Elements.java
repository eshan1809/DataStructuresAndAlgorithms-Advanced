/*
1. You are given an array(arr) of integers and a number k.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least k elements.
*/

import java.util.*;

public class maximumSumSubarrayWithAtLeast_K_Elements {
    public static int solution(int[] arr, int k) {
        // write your code here
        int[] dp = new int[arr.length];
        int curr = arr[0], sum = 0, ans;
        dp[0] = curr;
        for (int i = 1; i < arr.length; i++)
            dp[i] = curr = Math.max(curr + arr[i], arr[i]);
        for (int i = 0; i < k; i++)
            sum += arr[i];
        ans = sum;
        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - k];
            int val = sum;
            if (dp[i - k] > 0)
                val += dp[i - k];
            ans = Math.max(ans, val);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(arr, k));
    }
}
