/*
There are n cities and there are roads in between some of the cities. Somehow all the roads are damaged simultaneously. We have to repair the roads to connect the cities again. There is a fixed cost to repair a particular road. Find out the minimum cost to connect all the cities by repairing roads.
*/

import java.io.*;
import java.util.*;

public class minimumCostToConnectAllCities {
    static class Edge implements Comparable<Edge> {
        int v;
        int wt;

        Edge(int nbr, int wt) {
            this.v = nbr;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vtces; i++) {
            graph.add(new ArrayList<>());
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph.get(v1).add(new Edge(v2, wt));
            graph.get(v2).add(new Edge(v1, wt));
        }

        boolean[] visited = new boolean[vtces];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int wsf = 0, count = 0;
        ;
        pq.add(new Edge(0, 0));
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (visited[e.v])
                continue;
            visited[e.v] = true;
            wsf += e.wt;
            if (++count == vtces)
                break;
            for (Edge nb : graph.get(e.v)) {
                if (!visited[nb.v])
                    pq.add(nb);
            }
        }
        System.out.println(wsf);
    }

}
