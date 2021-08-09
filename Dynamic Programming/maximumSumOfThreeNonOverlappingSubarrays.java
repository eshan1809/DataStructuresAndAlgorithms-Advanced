/*
1. You are given an array(arr) of positive numbers and a number K.
2. You have to find the maximum sum of elements in three non-overlapping subarrays.
3. Also, you have to print indices representing the starting position of every subarray.
4. If there are multiple answers, print the lexicographically smallest one.
*/

import java.util.*;

public class maximumSumOfThreeNonOverlappingSubarrays {
    public static void solution(int[] arr, int k) {
        // write your code here
        int n = arr.length, sum = 0, start = 0, mid = 0, end = 0;
        int[] dp1 = new int[n], dp2 = new int[n], prefSum = new int[n];
        for (int i = 0; i < n; i++) {
            prefSum[i] = arr[i];
            if (i > 0)
                prefSum[i] += prefSum[i - 1];
            if (i < k) {
                sum += arr[i];
                dp1[i] = sum;
            } else {
                sum += arr[i] - arr[i - k];
                dp1[i] = Math.max(dp1[i - 1], sum);
            }
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i + k >= n) {
                sum += arr[i];
                dp2[i] = sum;
            } else {
                sum += arr[i] - arr[i + k];
                dp2[i] = Math.max(dp2[i + 1], sum);
            }
        }
        sum = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int pans = dp1[i - 1] + dp2[i + k] + prefSum[i + k - 1] - prefSum[i - 1];
            if (pans > sum) {
                sum = pans;
                mid = i;
                start = dp1[i - 1];
                end = dp2[i + k];
            }
        }

        for (int i = k - 1; i < mid; i++)
            if (prefSum[i] - (i - k < 0 ? 0 : prefSum[i - k]) == start) {
                start = i - k + 1;
                break;
            }
        for (int i = mid + 2 * k - 1; i < n; i++)
            if (prefSum[i] - prefSum[i - k] == end) {
                end = i - k + 1;
                break;
            }
        System.out.println(sum + " " + start + " " + mid + " " + end);
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
        solution(arr, k);
    }
}
