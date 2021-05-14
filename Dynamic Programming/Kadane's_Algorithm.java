/*
1. You are given an array(arr) of integers.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least one element.
*/

import java.io.*;
import java.util.*;

public class Kadane's_Algorithm {
    public static int solution(int[] arr) {
        // write your code here
        int curr = arr[0], max = arr[0];
        for(int i = 1; i < arr.length; i++){
            curr = Math.max(curr + arr[i], arr[i]);
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
