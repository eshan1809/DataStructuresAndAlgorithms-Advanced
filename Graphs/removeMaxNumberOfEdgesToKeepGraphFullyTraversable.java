/*
Alice and Bob have an undirected graph of n nodes and 3 types of edges:

Type 1: Can be traversed by Alice only.
Type 2: Can be traversed by Bob only.
Type 3: Can by traversed by both Alice and Bob.

Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.
Return the maximum number of edges you can remove, or return -1 if it's impossible for the graph to be fully traversed by Alice and Bob.
*/

import java.io.*;
import java.util.*;

public class removeMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(st[0]);
            edges[i][1] = Integer.parseInt(st[1]);
            edges[i][2] = Integer.parseInt(st[2]);
        }
        System.out.println(maxNumEdgesToRemove(n, edges));
    }

    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr2[0] - arr1[0];
            }
        });
        int[] parentAlice = new int[n + 1], rankAlice = new int[n + 1], parentBob = new int[n + 1],
                rankBob = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parentAlice[i] = parentBob[i] = i;
        int count = 0, countAlice = 0, countBob = 0;
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0], u = edges[i][1], v = edges[i][2];
            if (x == 3) {
                if (find(u, parentAlice) != find(v, parentAlice) || find(u, parentBob) != find(v, parentBob)) {
                    union(u, v, parentAlice, rankAlice);
                    union(u, v, parentBob, rankBob);
                    countAlice++;
                    countBob++;
                } else
                    count++;
            } else if (x == 2) {
                if (find(u, parentBob) != find(v, parentBob)) {
                    union(u, v, parentBob, rankBob);
                    countBob++;
                } else
                    count++;
            } else {
                if (find(u, parentAlice) != find(v, parentAlice)) {
                    union(u, v, parentAlice, rankAlice);
                    countAlice++;
                } else
                    count++;
            }
        }
        if (countAlice < n - 1 || countBob < n - 1)
            return -1;
        return count;
    }

    private static int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        int l = find(parent[x], parent);
        parent[x] = l;
        return l;
    }

    private static void union(int a, int b, int[] parent, int[] rank) {
        int la = find(a, parent), lb = find(b, parent);
        if (rank[la] > rank[lb])
            parent[lb] = la;
        else if (rank[la] < rank[lb])
            parent[la] = lb;
        else {
            parent[la] = lb;
            rank[lb]++;
        }
    }
}