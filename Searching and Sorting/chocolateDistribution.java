/*
1. Given an array A[] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
2. Each student gets exactly one packet.
3. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.
*/

import java.util.*;

public class chocolateDistribution {

    public static int find(int[] arr, int n, int m) {
        // write your code here
        Arrays.sort(arr);
        int ans = arr[m - 1] - arr[0];
        for (int i = m; i < n; i++)
            ans = Math.min(ans, arr[i] - arr[i - m + 1]);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // input work
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int ans = find(arr, n, m);
        scn.close();
        System.out.println(ans);
    }
}