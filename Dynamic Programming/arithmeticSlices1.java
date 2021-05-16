/*
1. You are given an array(arr) of integers.
2. You have to find the count of arithmetic slices in the given array.
3. Arithmetic slice is defined as the sub-array having all its elements in A.P and the length of sub-array should be greater than or equal to 3.
*/

import java.io.*;
import java.util.*;

public class arithmeticSlices1 {
    public static int solution(int[] arr) {
        // write your code here
        int sum = 0, prev = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2])
                sum += ++prev;
            else
                prev = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
