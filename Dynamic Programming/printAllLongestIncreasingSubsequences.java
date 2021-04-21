/*
1. You are given a number N representing number of elements.
2. You are given N space separated numbers.
3. Your task is to find & print  
    3.1) Length of "Longest Increasing Subsequence"(LIS).
    3.2) All "Longest Increasing Subsequence(s)"(LIS).
*/

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class printAllLongestIncreasingSubsequences {

    public static class Pair {
        int l;
        int i;
        int v;
        String psf;

        Pair(int l, int i, int v, String psf) {
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void solution(int[] arr) {
        // write your code here
        int[] dp = new int[arr.length];
        int lis = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++)
                if (arr[j] <= arr[i])
                    max = Math.max(max, dp[j]);
            dp[i] = max + 1;
            lis = Math.max(lis, dp[i]);
        }
        System.out.println(lis);
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < dp.length; i++)
            if (lis == dp[i])
                q.add(new Pair(lis, i, arr[i], arr[i] + ""));
        while (q.size() > 0) {
            Pair p = q.remove();
            if (p.l == 1)
                System.out.println(p.psf);
            for (int j = p.i; j >= 0; j--)
                if (dp[j] == p.l - 1 && arr[j] <= p.v)
                    q.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + p.psf));
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
        scn.close();
    }
}