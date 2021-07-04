/*
1. You are given an array of n numbers.
2. You have to find the sum of bit differences in all pairs that can be formed from n numbers.
3. Bit difference of two numbers is defined as the count of different bits at same positions in binary representations of two numbers.
*/

import java.util.*;

public class sumOfBitDifferencesOfAllPairs {

    public static long solution(int[] arr) {
        // write your code here
        long res = 0;
        for (int i = 0; i < 32; i++) {
            long count = 0;
            for (int val : arr)
                if (((1 << i) & val) != 0)
                    count++;
            res += count * (arr.length - count) * 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    }

}