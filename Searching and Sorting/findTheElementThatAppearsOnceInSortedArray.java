/*
Given a sorted array arr[] of size N. Find the element that appears only once in the array. All other elements appear exactly twice. 
*/

import java.util.*;
import java.io.*;

public class findTheElementThatAppearsOnceInSortedArray {

    public static int findSingleElement(int[] nums) {
        // write your code here
        int n = nums.length, lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (mid % 2 == 0) {
                if (mid > 0 && nums[mid - 1] == nums[mid])
                    hi = mid - 1;
                else if (mid < n && nums[mid + 1] == nums[mid])
                    lo = mid + 1;
                else
                    return nums[mid];
            } else {
                if (nums[mid - 1] == nums[mid])
                    lo = mid + 1;
                else if (nums[mid + 1] == nums[mid])
                    hi = mid - 1;
                else
                    return nums[mid];
            }
        }
        return nums[lo];
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
        int ans = findSingleElement(arr);
        System.out.println(ans);
    }
}