/*
1. Given an array arr of N integers. 
2. Your task is to write a program to find the maximum value of sum of arr[i]*i, where i = 0,1,2,...,n-1.
3. You are allowed to rearrange the elements of the array.
*/

import java.util.*;

public class maximizeSumOfElementMultipliedIndexOfAnArray {

    public static int maximise(int[] arr) {
        // write your code here
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 1; i < arr.length; i++)
            ans += arr[i] * i;
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