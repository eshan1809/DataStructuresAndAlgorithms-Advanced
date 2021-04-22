/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add up to "tar" or not.
5. Also, you have to print the indices of elements that should be selected to achieve the given target.
6. You have to print all such configurations.
*/

import java.io.*;
import java.util.*;

public class printAllPathsWithTargetSumSubset {

    public static class Pair {
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int tar = Integer.parseInt(br.readLine());

        // write your code here

        boolean[][] dp = new boolean[n + 1][tar + 1];
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < tar + 1; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        if (dp[n][tar]) {
            System.out.println(true);
            Queue<Pair> q = new ArrayDeque<>();
            q.add(new Pair(n, tar, ""));
            while (q.size() > 0) {
                Pair p = q.remove();
                if (p.i == 0 || p.j == 0)
                    System.out.println(p.psf);
                else {
                    int remTar = p.j - arr[p.i - 1];
                    if (remTar >= 0 && dp[p.i - 1][remTar])
                        q.add(new Pair(p.i - 1, remTar, (p.i - 1) + " " + p.psf));
                    if (dp[p.i - 1][p.j])
                        q.add(new Pair(p.i - 1, p.j, p.psf));
                }
            }
        } else
            System.out.println(false);
    }
}