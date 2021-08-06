/*
Given an m*n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ZeroOneMatrix {
    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

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

        int[][] ans = updateMatrix(arr);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0)
                    q.add(new Pair(i, j));
                else
                    matrix[i][j] = -1;
            }
        }

        while (!q.isEmpty()) {
            Pair rem = q.remove();
            if (rem.x > 0 && matrix[rem.x - 1][rem.y] == -1) {
                matrix[rem.x - 1][rem.y] = matrix[rem.x][rem.y] + 1;
                q.add(new Pair(rem.x - 1, rem.y));
            }
            if (rem.y < m - 1 && matrix[rem.x][rem.y + 1] == -1) {
                matrix[rem.x][rem.y + 1] = matrix[rem.x][rem.y] + 1;
                q.add(new Pair(rem.x, rem.y + 1));
            }
            if (rem.x < n - 1 && matrix[rem.x + 1][rem.y] == -1) {
                matrix[rem.x + 1][rem.y] = matrix[rem.x][rem.y] + 1;
                q.add(new Pair(rem.x + 1, rem.y));
            }
            if (rem.y > 0 && matrix[rem.x][rem.y - 1] == -1) {
                matrix[rem.x][rem.y - 1] = matrix[rem.x][rem.y] + 1;
                q.add(new Pair(rem.x, rem.y - 1));
            }
        }

        return matrix;
    }
}