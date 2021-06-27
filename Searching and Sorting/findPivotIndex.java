/*
1. Given an array of integers nums, calculate the pivot index of this array.
2. The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
3. If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
4. Return the leftmost pivot index. If no such index exists, return -1.
*/

import java.util.*;
import java.io.*;

public class findPivotIndex {

    public static int pivot_index(int[] nums) {
        // write your code here
        int sl = 0, sr = 0;
        for (int i = 0; i < nums.length; i++) {
            sr += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            sr -= nums[i];
            if (sl == sr) {
                return i;
            }
            sl += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        int pi = pivot_index(arr);
        System.out.println(pi);
    }
}