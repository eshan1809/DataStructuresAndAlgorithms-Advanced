/*
You are given 2 integers N and M , N is the number of vertices, M is the number of edges. You'll also be given ai, bi and wi where ai and bi represents an edge from a vertex ai to a vertex bi and wi respresents the weight of that edge.
Your task is to find the shortest path from source vertex (vertex number 1) to all other vertices.

Note : use bellman ford algo.
*/

import java.util.*;

public class bellmanFord {
    private static class Edge implements Comparable<Edge> {
        int vt, nbr, wt;

        Edge(int vt, int nbr, int wt) {
            this.vt = vt;
            this.nbr = nbr;
            this.wt = wt;
        }

        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt(), edges = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            int v1 = scn.nextInt(), v2 = scn.nextInt(), wt = scn.nextInt();
            graph[v1 - 1].add(new Edge(v1, v2, wt));
            graph[v2 - 1].add(new Edge(v2, v1, wt));
        }
        scn.close();
        boolean[] visited = new boolean[vtces];
        int[] arr = new int[vtces - 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 1, 0));
        while (pq.size() > 0) {
            Edge rem = pq.remove();
            if (visited[rem.nbr - 1])
                continue;
            visited[rem.nbr - 1] = true;
            if (rem.nbr > 1)
                arr[rem.nbr - 2] = rem.wt;
            for (Edge e : graph[rem.nbr - 1])
                if (!visited[e.nbr - 1])
                    pq.add(new Edge(rem.nbr, e.nbr, rem.wt + e.wt));
        }
        for (int i : arr)
            System.out.print(i + " ");
    }
}
