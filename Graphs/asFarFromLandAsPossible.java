/*
Given an n*n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class asFarFromLandAsPossible {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(maxDistance(arr));

    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int maxDistance(int[][] grid) {
        int n = grid.length, ans = 0;
        int[][] drn = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                }
            }
        }
        if (q.size() == 0 || q.size() == n * n)
            return -1;
        while (!q.isEmpty()) {
            int size = q.size();
            ans++;
            while (size-- > 0) {
                Pair rem = q.remove();
                for (int d = 0; d < 4; d++) {
                    int x = rem.x + drn[d][0], y = rem.y + drn[d][1];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        q.add(new Pair(x, y));
                    }
                }
            }
        }
        return ans - 1;
    }
}