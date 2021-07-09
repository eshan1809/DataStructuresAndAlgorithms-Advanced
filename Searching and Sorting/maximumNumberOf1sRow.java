/*
Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.
*/

import java.util.*;

public class maximumNumberOf1sRow {

    public static int findRow(int[][] mat) {
        // write your code here
        int ans = 0, noo = 0, n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = m - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (mat[i][mid] == 1) {
                    if (m - mid > noo) {
                        noo = m - mid;
                        ans = i;
                    }
                    hi = mid - 1;
                } else
                    lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        scn.close();
        System.out.println(findRow(mat));
    }
}