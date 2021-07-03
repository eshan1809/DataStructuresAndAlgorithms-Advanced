/*
1. You are given an array of integers.
2. You have to find the XOR of sum of all pairs in the array.
*/

import java.util.*;

public class xorOfSumOfAllPairs {

    public static int solution(int[] arr) {
        // write your code here
        int xor = 0;
        for (int i : arr)
            xor ^= (2 * i);
        return xor;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    }
}