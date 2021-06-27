/*
1. Given an ascending sorted rotated array arr of distinct integers of size N. 
2. The array is right rotated K times. 
3. Your task is to find the value of K.
*/

import java.util.*;

public class findRotationCount {

    public static int solution(int[] arr) {
        // write your code here
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1])
                return i;
        return 0;
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
        int ans = solution(arr);
        System.out.println(ans);
    }
}