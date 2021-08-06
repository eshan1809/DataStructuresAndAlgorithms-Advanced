/*
Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.
*/

import java.io.*;
import java.util.*;

public class motherVertex {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int u = Integer.parseInt(st[0]) - 1;
            int v = Integer.parseInt(st[1]) - 1;
            graph.get(u).add(v);
        }

        System.out.println(findMotherVertex(n, graph));
    }

    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < N; i++)
            if (bfs(N, adj, i) == N)
                return i + 1;
        return -1;
    }

    private static int bfs(int N, ArrayList<ArrayList<Integer>> adj, int src) {
        int count = 0;
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        while (!q.isEmpty()) {
            int rem = q.remove();
            if (visited[rem])
                continue;
            visited[rem] = true;
            count++;
            for (int nbr : adj.get(rem))
                if (!visited[nbr])
                    q.add(nbr);
        }
        return count;
    }
}
