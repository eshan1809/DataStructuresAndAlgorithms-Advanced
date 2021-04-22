/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
7. You are required to traverse through the matrix and print the cost of the path which is least costly.
8. Also, you have to print all the paths with minimum cost.
*/

import java.io.*;
import java.util.*;

public class printAllPathsWithMinimumCost {

    public static class Pair {
        int i, j;
        String psf;

        Pair(int i, int j, String psf) {
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
        dp[n - 1][m - 1] = arr[n - 1][m - 1];
        for (int i = m - 2; i >= 0; i--)
            dp[n - 1][i] = dp[n - 1][i + 1] + arr[n - 1][i];

        for (int i = n - 2; i >= 0; i--)
            dp[i][m - 1] = dp[i + 1][m - 1] + arr[i][m - 1];

        for (int i = n - 2; i >= 0; i--)
            for (int j = m - 2; j >= 0; j--)
                dp[i][j] = arr[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);

        System.out.println(dp[0][0]);
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0, ""));
        while (q.size() > 0) {
            Pair p = q.remove();
            if (p.i == n - 1 && p.j == m - 1)
                System.out.println(p.psf);

            int nxt = dp[p.i][p.j] - arr[p.i][p.j];

            if (p.i + 1 < n && dp[p.i + 1][p.j] == nxt)
                q.add(new Pair(p.i + 1, p.j, p.psf + "V"));

            if (p.j + 1 < m && dp[p.i][p.j + 1] == nxt)
                q.add(new Pair(p.i, p.j + 1, p.psf + "H"));
        }
    }
}