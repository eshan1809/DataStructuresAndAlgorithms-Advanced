/*
You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [xi, yi] indicates that there is an edge between nodes xi and yi in the graph.
Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
*/

import java.io.*;

public class redundantConnection {
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

        int[] ans = findRedundantConnection(pos);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1], rank = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        for (int[] edge : edges) {
            int v1 = edge[0], v2 = edge[1];
            int lv1 = find(parent, v1), lv2 = find(parent, v2);
            if (lv1 != lv2) {
                if (rank[lv1] > rank[lv2])
                    parent[lv2] = lv1;
                else if (rank[lv2] > rank[lv1])
                    parent[lv1] = lv2;
                else {
                    parent[lv2] = lv1;
                    rank[lv1]++;
                }
            } else
                return edge;
        }

        return new int[2];
    }

    private static int find(int[] parent, int f) {
        if (parent[f] == f)
            return f;
        return parent[f] = find(parent, parent[f]);
    }
}