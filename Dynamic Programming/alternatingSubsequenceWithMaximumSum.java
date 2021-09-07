/*
1. You are given an array(arr) of integers.
2. You have to find the alternating subsequence wit maximum sum.
3. The alternating subsequence should start with the first element of the array.
4. The first step in alternating subsequence should be decreasing, then increasing, then decreasing and so on.

Note -> If the array contains only one element, then your answer should be that element itself.
*/

import java.util.*;

public class alternatingSubsequenceWithMaximumSum {

    public static int solution(int[] arr) {
        // write your code here
        return helper(arr, 0, 0, new Integer[arr.length][2]);
    }

    private static int helper(int[] arr, int idx, int flow, Integer[][] dp) {
        if (idx == arr.length)
            return 0;
        if (dp[idx][flow] != null)
            return dp[idx][flow];
        int ans = 0, call = 0;
        if (flow == 0) {
            for (int i = idx + 1; i < arr.length; i++) {
                if (arr[i] >= arr[idx] && call > 0)
                    break;
                if (arr[i] < arr[idx]) {
                    ans = Math.max(ans, helper(arr, i, 1, dp));
                    call++;
                }
            }
        } else {
            for (int i = idx + 1; i < arr.length; i++) {
                if (arr[i] <= arr[idx] && call > 0)
                    break;
                if (arr[i] > arr[idx]) {
                    ans = Math.max(ans, helper(arr, i, 0, dp));
                    call++;
                }
            }
        }
        dp[idx][flow] = ans + arr[idx];
        return ans + arr[idx];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    }

}