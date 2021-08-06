/*
Given an m*n binary matrix mat, return the number of distinct island.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class numberOfDistinctIsland {

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

        System.out.println(numDistinctIslands(arr));

    }

    public static StringBuilder psf = new StringBuilder();

    public static int numDistinctIslands(int[][] arr) {
        // write your code here
        int n = arr.length, m = arr[0].length, count = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    convertOnesIntoZeros(arr, i, j, n, m);
                    String s = psf.toString();
                    if (!set.contains(s)) {
                        set.add(s);
                        count++;
                    }
                    psf = new StringBuilder();
                }
            }
        }
        return count;
    }

    private static void convertOnesIntoZeros(int[][] arr, int i, int j, int n, int m) {
        arr[i][j] = 0;
        if (i > 0 && arr[i - 1][j] == 1) {
            psf.append('U');
            convertOnesIntoZeros(arr, i - 1, j, n, m);
        }
        if (j < m - 1 && arr[i][j + 1] == 1) {
            psf.append('R');
            convertOnesIntoZeros(arr, i, j + 1, n, m);
        }
        if (i < n - 1 && arr[i + 1][j] == 1) {
            psf.append('D');
            convertOnesIntoZeros(arr, i + 1, j, n, m);
        }
        if (j > 0 && arr[i][j - 1] == 1) {
            psf.append('L');
            convertOnesIntoZeros(arr, i, j - 1, n, m);
        }
        psf.append('Z');
    }
}