/*
Given an m*n matrix mat, Originally, the 2D matrix is all 0 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid mat[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.You need to return an array of size K.
*/

import java.util.*;
import java.io.*;

public class numberOfIsland2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);
        int q = Integer.parseInt(st[2]);

        int[][] pos = new int[q][2];
        for (int i = 0; i < q; i++) {
            st = br.readLine().split(" ");
            pos[i][0] = Integer.parseInt(st[0]);
            pos[i][1] = Integer.parseInt(st[1]);
        }

        System.out.println(numIslands2(m, n, pos));
    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new ArrayList<>();
        int[] parent = new int[m * n], rank = new int[m * n];
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        Arrays.fill(parent, -1);

        int count = 0;
        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0], col = positions[i][1], cell = row * m + col;
            if (parent[cell] != -1) {
                list.add(count);
                continue;
            }
            parent[cell] = cell;
            rank[cell] = 1;
            count++;

            for (int j = 0; j < 4; j++) {
                int nbrRow = row + dirs[j][0], nbrCol = col + dirs[j][1], nbrCell = nbrRow * m + nbrCol;

                if (nbrRow < 0 || nbrCol < 0 || nbrRow >= m || nbrCol >= n || parent[nbrCell] == -1)
                    continue;

                int lx = find(cell, parent), ly = find(nbrCell, parent);
                if (lx != ly) {
                    if (rank[lx] > rank[ly])
                        parent[ly] = lx;
                    else if (rank[ly] > rank[lx])
                        parent[lx] = ly;
                    else {
                        parent[ly] = lx;
                        rank[lx]++;
                    }
                    count--;
                }
            }

            list.add(count);
        }

        return list;
    }

    private static int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        int temp = find(parent[x], parent);
        parent[x] = temp;
        return temp;
    }
}