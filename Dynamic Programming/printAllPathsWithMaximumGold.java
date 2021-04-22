/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
8. Also, you have to print all paths with maximum gold.
*/

import java.io.*;
import java.util.*;

public class printAllPathsWithMaximumGold {
    public static class Pair {
        int i, j;
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
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        // write your code here
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = arr[i][m - 1];
        }
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                dp[i][j] = arr[i][j];
                if (i == 0) {
                    dp[i][j] += Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == n - 1) {
                    dp[i][j] += Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {
                    dp[i][j] += Math.max(Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]), dp[i][j + 1]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][0]);
        }

        System.out.println(max);

        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == max) {
                q.add(new Pair(i, 0, i + ""));
            }
        }
        while (q.size() > 0) {
            Pair p = q.remove();
            if (p.j == m - 1) {
                System.out.println(p.psf);
            }
            int rem = dp[p.i][p.j] - arr[p.i][p.j];
            if (p.j < m - 1) {
                if (p.i != 0 && dp[p.i - 1][p.j + 1] == rem) {
                    q.add(new Pair(p.i - 1, p.j + 1, p.psf + " d1"));
                }
                if (dp[p.i][p.j + 1] == rem) {
                    q.add(new Pair(p.i, p.j + 1, p.psf + " d2"));
                }
                if (p.i != n - 1 && dp[p.i + 1][p.j + 1] == rem) {
                    q.add(new Pair(p.i + 1, p.j + 1, p.psf + " d3"));
                }
            }
        }
    }
}
