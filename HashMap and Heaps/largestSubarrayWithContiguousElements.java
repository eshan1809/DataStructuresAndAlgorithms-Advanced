/*
1. You are given an array(arr) of integers. Values may be duplicated.
2. You have to find the length of the largest subarray with contiguous elements.

Note -> The contiguous elements can be in any order(not necessarily in increasing order).
*/

import java.util.*;

public class largestSubarrayWithContiguousElements {
    public static int solution(int[] arr) {
        // write your code here

        return 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    }
}
