/*
In a given 2D binary array grid, there are two islands. Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
Return the smallest number of 0s that must be flipped. (It is guaranteed that the answer is at least 1.)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class shortestBridge {

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

        System.out.println(shortestBridge(arr));

    }

    static class Pair1 {
        int x, y;

        Pair1(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Pair2 implements Comparable<Pair2> {
        int x, y, z;

        Pair2(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int compareTo(Pair2 o) {
            return this.z - o.z;
        }
    }

    private static void change(int[][] grid, int i, int j, int n) {
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        boolean[][] visited = new boolean[n][n];
        Queue<Pair1> q = new ArrayDeque<>();
        q.add(new Pair1(i, j));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair1 p = q.remove();
                if (grid[p.x][p.y] == -1)
                    continue;
                grid[p.x][p.y] = -1;
                for (int d = 0; d < 4; d++) {
                    int x = p.x + dirs[d][0], y = p.y + dirs[d][1];
                    if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 1) {
                        q.add(new Pair1(x, y));
                    }
                }
            }
        }
    }

    private static int[] changeOneIsland(int[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    change(grid, i, j, n);
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    public static int shortestBridge(int[][] grid) {
        int n = grid.length, minCost = 0;
        int[] arr = changeOneIsland(grid, n);
        return solution(grid, n, arr[0], arr[1]);
    }

    private static int solution(int[][] grid, int n, int i, int j) {
        int minCost = 0;
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        PriorityQueue<Pair2> q = new PriorityQueue<>();
        q.add(new Pair2(i, j, 0));
        grid[i][j] = -2;
        while (!q.isEmpty()) {
            Pair2 p = q.poll();
            for (int d = 0; d < 4; d++) {
                int x = p.x + dirs[d][0], y = p.y + dirs[d][1];
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    int ele = grid[x][y];
                    if (ele == 1) {
                        minCost = p.z;
                        return minCost;
                    } else if (ele != -2) {
                        grid[x][y] = -2;
                        q.add(new Pair2(x, y, p.z + (ele == 0 ? 1 : 0)));
                    }
                }
            }
        }
        return minCost;
    }
}
