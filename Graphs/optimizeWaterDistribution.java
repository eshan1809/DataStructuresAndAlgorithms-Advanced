/*
There are n construction sites in a town. We want to supply water for all the construction sites by building wells and laying pipes.

For each site i, we can either build a well inside it directly with cost wells[i-1], or pipe in water from another well to it. The costs to lay pipes between
sites are given by the 2d array cost, where each row of cost contains 3 numbers ai,bi and wi where wi is the cost to connect ai to bi. connections are bidirectional.

Return the minimum total cost to supply water to all the construction sites.
*/

import java.io.*;
import java.util.*;

class optimizeWaterDistribution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int v = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);

        int[] wells = new int[v];
        String[] words = br.readLine().split(" ");

        for (int i = 0; i < wells.length; i++) {
            wells[i] = Integer.parseInt(words[i]);
        }

        int[][] pipes = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st1 = br.readLine().split(" ");
            pipes[i][0] = Integer.parseInt(st1[0]);
            pipes[i][1] = Integer.parseInt(st1[1]);
            pipes[i][2] = Integer.parseInt(st1[2]);

        }

        System.out.println(minCostToSupplyWater(v, wells, pipes));

    }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<Pipe>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < pipes.length; i++) {
            int v1 = pipes[i][0], v2 = pipes[i][1], wt = pipes[i][2];
            graph[v1].add(new Pipe(v2, wt));
            graph[v2].add(new Pipe(v1, wt));
        }

        for (int i = 1; i <= n; i++) {
            graph[i].add(new Pipe(0, wells[i - 1]));
            graph[0].add(new Pipe(i, wells[i - 1]));
        }

        int ans = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Pipe> pq = new PriorityQueue<>();
        pq.add(new Pipe(0, 0));
        while (!pq.isEmpty()) {
            Pipe rem = pq.remove();
            if (!visited[rem.vt]) {
                visited[rem.vt] = true;
                ans += rem.wt;
                for (Pipe p : graph[rem.vt])
                    if (!visited[p.vt])
                        pq.add(p);
            }
        }
        return ans;
    }

    public static class Pipe implements Comparable<Pipe> {
        int vt, wt;

        Pipe(int vt, int wt) {
            this.vt = vt;
            this.wt = wt;
        }

        public int compareTo(Pipe o) {
            return this.wt - o.wt;
        }
    }
}
