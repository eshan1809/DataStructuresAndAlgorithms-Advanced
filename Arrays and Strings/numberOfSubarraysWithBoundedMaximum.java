/*
1. We have an array 'arr' of positive integers, and two positive integers left and right (left is smaller than right).
2. Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least left and at most right.
*/

import java.util.*;

public class numberOfSubarraysWithBoundedMaximum {

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // write your code here
        int start = -1, end = -1, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                start = i;
                end = i;
            } else if (nums[i] >= left && nums[i] <= right)
                end = i;
            ans += end - start;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int left = scn.nextInt();
        int right = scn.nextInt();
        scn.close();
        int count = numSubarrayBoundedMax(arr, left, right);
        System.out.println(count);
    }
}