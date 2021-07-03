/*
1. You are given an array of numbers.
2. All numbers occur twice in the array except one.
3. You have to find that number by traversing only once in the array and without using any extra 
     space.
*/

import java.util.*;

public class allRepeatingExceptOne {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        // write your code here
        scn.close();
        int ans = arr[0];
        for (int i = 1; i < n; i++)
            ans = ans ^ arr[i];
        System.out.println(ans);
    }

}