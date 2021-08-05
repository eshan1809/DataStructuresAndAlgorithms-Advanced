/*
You are given an m * n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell. A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class numberOfEnclaves {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(numEnclaves(arr));

    }

    public static int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++)
            if (grid[i][0] == 1)
                turnBoundaryZeroToOne(grid, i, 0, n, m);
        for (int i = 0; i < n; i++)
            if (grid[i][m - 1] == 1)
                turnBoundaryZeroToOne(grid, i, m - 1, n, m);
        for (int j = 1; j < m - 1; j++)
            if (grid[0][j] == 1)
                turnBoundaryZeroToOne(grid, 0, j, n, m);
        for (int j = 1; j < m - 1; j++)
            if (grid[n - 1][j] == 1)
                turnBoundaryZeroToOne(grid, n - 1, j, n, m);

        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                ans += grid[i][j];
        return ans;
    }

    private static void turnBoundaryZeroToOne(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i == n || j == m || grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        turnBoundaryZeroToOne(grid, i + 1, j, n, m);
        turnBoundaryZeroToOne(grid, i, j + 1, n, m);
        turnBoundaryZeroToOne(grid, i - 1, j, n, m);
        turnBoundaryZeroToOne(grid, i, j - 1, n, m);
    }

}