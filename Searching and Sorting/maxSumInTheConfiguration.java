/*
1. Given an array, you have to find the max sum of i*A[i] where A[i] is the element at index i in the array. 
2. The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.
*/

import java.util.*;

public class maxSumInTheConfiguration {

    public static int maximise(int[] arr) {
        // write your code here
        int prev = 0, ans = 0, sum = arr[0], n = arr.length;
        for (int i = 1; i < n; i++) {
            sum += arr[i];
            prev += arr[i] * i;
        }
        ans = prev;
        for (int i = 0; i < n - 1; i++) {
            prev += sum - n * arr[n - 1 - i];
            ans = Math.max(prev, ans);
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
        scn.close();
        int ans = maximise(arr);
        System.out.println(ans);
    }
}