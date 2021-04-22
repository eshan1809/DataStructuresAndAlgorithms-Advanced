/*
1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print  
    3.1) "MINIMUM JUMPS" need from 0th step to (n-1)th step.
    3.2) all configurations of "MINIMUM JUMPS".
*/

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class printAllPathsWithMinimumJumps {

    public static class Pair {
        int idx, size, jump;
        String psf;

        Pair(int i, int s, int j, String str) {
            idx = i;
            size = s;
            jump = j;
            psf = str;
        }
    }

    public static void Solution(int arr[]) {
        // write your code here
        int[] dp = new int[arr.length];
        for (int i = arr.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++)
                min = Math.min(min, dp[i + j]);
            dp[i] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
        }

        System.out.println(dp[0]);
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, arr[0], dp[0], 0 + ""));

        while (q.size() > 0) {
            Pair p = q.remove();

            if (p.jump == 0)
                System.out.println(p.psf + " .");

            for (int j = 1; j <= p.size && p.idx + j < dp.length; j++) {
                int cidx = p.idx + j;
                if (dp[cidx] == p.jump - 1)
                    q.add(new Pair(cidx, arr[cidx], dp[cidx], p.psf + " -> " + cidx));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
        Solution(arr);
        scn.close();
    }
}
