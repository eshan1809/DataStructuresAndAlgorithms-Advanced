/*
1. Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
2. Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
3. Given the sorted rotated array nums of unique elements, return the minimum element of this array.
4. You must write an algorithm that runs in O(log n) time.
*/

import java.util.*;

public class findMinimumInRotatedSortedArray {

    public static int findMinimum(int[] nums) {
        // write your code here
        int low = 0, high = nums.length - 1, res = nums[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            res = Math.min(res, nums[mid]);
            if (nums[low] < nums[mid]) {
                res = Math.min(res, nums[low]);
                low = mid + 1;
            } else if (nums[mid] < nums[high])
                high = mid - 1;
            else
                low++;
        }
        return res;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        int ans = findMinimum(arr);
        System.out.println(ans);
    }
}