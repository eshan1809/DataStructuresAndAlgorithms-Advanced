/*
1. There is an integer array nums sorted in ascending order (with distinct values).
2. nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
3. Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
4. You must write an algorithm with O(log n) runtime complexity.
*/

import java.util.*;
import java.io.*;

public class searchInRotatedSortedArray {

    public static int find(int[] nums, int target) {
        // write your code here
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[l] <= nums[mid]) { // nums[left to mid] is sorted
                if (target >= nums[l] && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else { // nums[mid to right] is sorted
                if (target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
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
        int ans = find(arr, target);
        System.out.println(ans);
    }
}