/*
1. Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
2. Write an algorithm to minimize the largest sum among these m subarrays.
*/

import java.util.*;
import java.io.*;

public class splitArrayLargestSum {

    public static int splitArray(int[] arr, int m) {
        // write your code here
        int sum = 0, max = 0;
        for (int i : arr) {
            sum += i;
            max = Math.max(max, i);
        }
        int lo = max, hi = sum, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int load = 0, student = 0;
            for (int i : arr) {
                if (load + i <= mid)
                    load += i;
                else {
                    student++;
                    load = i;
                }
            }
            if (student < m) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
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

        int m = scn.nextInt();
        scn.close();
        int ans = splitArray(arr, m);
        System.out.println(ans);
    }
}