/*
You are given a directed graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [xi, yi] indicates that there is a directed edge between nodes xi and yi in the graph.
Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

Note : The difference between redundant connection and redundant connection 2 is that in later the graph is directed and in the former graph is undirected.
*/

import java.util.*;
import java.io.*;

public class redundantConnection2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);

        int[][] pos = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            pos[i][0] = Integer.parseInt(st[0]);
            pos[i][1] = Integer.parseInt(st[1]);
        }

        int[] ans = findRedundantDirectedConnection(pos);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n + 1];
        Arrays.fill(indegree, -1);
        int bl1 = -1, bl2 = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[edges[i][1]] != -1) {
                bl1 = i;
                bl2 = indegree[edges[i][1]];
                break;
            }
            indegree[edges[i][1]] = i;
        }

        int[] parent = new int[n + 1], rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (i == bl1)
                continue;
            int v1 = edges[i][0], v2 = edges[i][1];
            boolean flag = union(v1, v2, parent, rank);
            if (flag) {
                if (bl1 == -1) {
                    return edges[i];
                } else {
                    return edges[bl2];
                }
            }
        }
        return edges[bl1];
    }

    private static int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }

    private static boolean union(int x, int y, int[] parent, int[] rank) {
        int lx = find(x, parent), ly = find(y, parent);
        if (lx == ly)
            return true;
        if (rank[lx] > rank[ly])
            parent[ly] = lx;
        else if (rank[lx] < rank[ly])
            parent[lx] = ly;
        else {
            parent[lx] = ly;
            rank[ly]++;
        }
        return false;
    }
}