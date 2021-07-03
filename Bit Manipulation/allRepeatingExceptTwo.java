/*
1. You are given an array of numbers.
2. You have to find 2 non-repeating numbers in an array.
3. All repeating numbers are repeating even number of times.
*/

import java.util.*;

public class allRepeatingExceptTwo {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        solution(arr);
    }

    public static void solution(int[] arr) {
        // write your code here
        int xor = 0, xor1 = 0, xor2 = 0;
        for (int val : arr)
            xor ^= val;
        int rmsbm = xor & -xor;
        for (int val : arr) {
            if ((val & rmsbm) == 0)
                xor1 ^= val;
            else
                xor2 ^= val;
        }
        System.out.println(Math.min(xor1, xor2));
        System.out.println(Math.max(xor1, xor2));
    }

}