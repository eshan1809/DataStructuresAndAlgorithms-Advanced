/*
1. You are given four integers row, cols, rCenter, and cCenter. There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).
2. Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter) from the smallest distance to the largest distance.
*/

import java.util.*;

public class matrixCellsInDistanceOrder {

    public static int[][] solve(int rows, int cols, int rCenter, int cCenter) {
        // write your code here
        int[][] ans = new int[rows * cols][2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int bno = i * cols + j;
                ans[bno][0] = i;
                ans[bno][1] = j;
            }
        }

        Arrays.sort(ans, (a, b) -> {
            int d1 = Math.abs(rCenter - a[0]) + Math.abs(cCenter - a[1]);
            int d2 = Math.abs(rCenter - b[0]) + Math.abs(cCenter - b[1]);
            return d1 - d2;
        });

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();
        int rCenter = scn.nextInt();
        int cCenter = scn.nextInt();
        scn.close();
        int[][] ans = solve(rows, cols, rCenter, cCenter);

        for (int i = 0; i < ans.length; i++) {
            System.out.print("(" + ans[i][0] + ", " + ans[i][1] + "), ");
        }
        System.out.println();
    }
}