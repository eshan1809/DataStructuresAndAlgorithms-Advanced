/*
1. You will be given a matrix, 2d Array and number of its columns and rows.
 2. Matrix represents a grid, where 1 is land and 0 is water. 
 3. Each tile/element has 1 as width and height.
 4. You need to find perimeter of the island formed by land.
 5. Input and output is handled for you
 6. It is a functional problem, please do not modify main()
 */

import java.io.*;
import java.util.*;

public class islandPerimeter {
    public static int solution(int[][] grid) {
        // Code Here
        int ans = 0, n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0)
                        ans++;
                    if (j == 0 || grid[i][j - 1] == 0)
                        ans++;
                    if (i == n - 1 || grid[i + 1][j] == 0)
                        ans++;
                    if (j == m - 1 || grid[i][j + 1] == 0)
                        ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] grid = new int[row][col];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(solution(grid));
    }
}