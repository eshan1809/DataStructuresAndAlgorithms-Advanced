/*
1. You are given an array of numbers.
2. All numbers occur thrice in the array except one.
3. You have to find the element that occurs once.
*/

import java.util.*;

public class allRepeatingThreeTimesExceptOne {

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
        int a0 = Integer.MAX_VALUE, a1 = 0, a2 = 0;
        for (int i : arr) {
            int b0 = (a0 & i), b1 = (a1 & i), b2 = (a2 & i);
            a1 |= b0;
            a2 |= b1;
            a0 |= b2;
            a0 &= (~b0);
            a1 &= (~b1);
            a2 &= (~b2);
        }
        System.out.println(a1);
    }

}