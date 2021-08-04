/*
You are given an m * n matrix containing 0, 1 or 2 , where 0 represents an empty cell, 1 represents a fresh orange, 2 represents rotten orange. Every hour, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Print the minimum number of hours that must elapse until no cell has a fresh orange.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class rottingOranges {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(orangesRotting(arr));

    }

    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length, time = -1;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair rem = q.remove();
                for (int i = 0; i < 4; i++) {
                    int x = rem.row + dirs[i][0], y = rem.col + dirs[i][1];
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.add(new Pair(x, y));
                    }
                }
            }
            time++;
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    return -1;
        return Math.max(time, 0);
    }
}
