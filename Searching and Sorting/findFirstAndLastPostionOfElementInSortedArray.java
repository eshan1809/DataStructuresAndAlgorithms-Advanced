/*
1. Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
2. If target is not found in the array, return [-1, -1].
3. You must write an algorithm with O(log n) runtime complexity.
*/

import java.util.*;

public class findFirstAndLastPostionOfElementInSortedArray {

    // return an array of size two, which contains first and last index of target.
    public static int[] find(int[] nums, int target) {
        // write your code here
        int[] ans = { -1, -1 };
        int n = nums.length, lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                ans[0] = mid;
                hi = mid - 1;
            } else if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                ans[1] = mid;
                lo = mid + 1;
            } else if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
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

        int target = scn.nextInt();
        scn.close();
        int[] ans = find(arr, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}