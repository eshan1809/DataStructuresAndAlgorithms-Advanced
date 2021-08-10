/*
There are n vertices and there are edges in between some of the vertices. Find the sum  of edge weight of minimum spanning tree.
*/

import java.util.*;
import java.io.*;

public class kruskalAlgorithm {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(st[0]);
            edges[i][1] = Integer.parseInt(st[1]);
            edges[i][2] = Integer.parseInt(st[2]);
        }

        System.out.println(minCostToSupplyWater(v, edges));
    }

    static int[] parent;
    static int[] rank;

    public static int minCostToSupplyWater(int n, int[][] pipes) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        Arrays.sort(pipes, (a, b) -> a[2] - b[2]);
        int cost = 0;
        for (int i = 0; i < pipes.length; i++)
            if (union(pipes[i][0], pipes[i][1]))
                cost += pipes[i][2];
        return cost;
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int x, int y) {
        int lx = find(x), ly = find(y);
        if (lx == ly)
            return false;
        if (rank[lx] > rank[ly])
            parent[ly] = lx;
        else if (rank[ly] > rank[lx])
            parent[lx] = ly;
        else {
            parent[lx] = ly;
            rank[ly]++;
        }
        return true;
    }
}
