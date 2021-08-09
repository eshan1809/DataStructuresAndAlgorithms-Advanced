/*
1. You are given an array(arr) of positive numbers and two numbers X and Y.
2. You have to find the maximum sum of elements in two non-overlapping subarrays.
3. One subarray must of length X and the other must be of length Y.
*/

import java.util.*;

public class maximumSumOfTwoNonoverlappingSubarrays {

    public static int solution(int[] arr, int x, int y) {
        // write your code here
        int n = arr.length;
        int[] dp1 = new int[n], dp2 = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i < x) {
                sum += arr[i];
                dp1[i] = sum;
            } else {
                sum += arr[i] - arr[i - x];
                dp1[i] = i - 1 < 0 ? 0 : Math.max(dp1[i - 1], sum);
            }
        }
        sum = 0;
        for (int i = n - 1; i > 0; i--) {
            if (i + y >= n) {
                sum += arr[i];
                dp2[i] = sum;
            } else {
                sum += arr[i] - arr[i + y];
                dp2[i] = i + 1 == n ? 0 : Math.max(dp2[i + 1], sum);
            }
        }
        int ans = 0;
        for (int i = x - 1; i < n - y; i++)
            ans = Math.max(ans, dp1[i] + dp2[i + 1]);

        sum = 0;
        for (int i = 0; i < n; i++) {
            if (i < y) {
                sum += arr[i];
                dp1[i] = sum;
            } else {
                sum += arr[i] - arr[i - y];
                dp1[i] = i - 1 < 0 ? 0 : Math.max(dp1[i - 1], sum);
            }
        }
        sum = 0;
        for (int i = n - 1; i > 0; i--) {
            if (i + x >= n) {
                sum += arr[i];
                dp2[i] = sum;
            } else {
                sum += arr[i] - arr[i + x];
                dp2[i] = i + 1 == n ? 0 : Math.max(dp2[i + 1], sum);
            }
        }

        for (int i = y - 1; i < n - x; i++)
            ans = Math.max(ans, dp1[i] + dp2[i + 1]);

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        int y = scn.nextInt();
        scn.close();
        System.out.println(solution(arr, x, y));
    }

}