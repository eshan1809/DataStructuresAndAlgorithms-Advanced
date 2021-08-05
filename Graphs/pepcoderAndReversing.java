/*
You are given 2 integers N and M , N is the number of vertices, M is the number of edges. You'll also be given ai and bi where ai and bi represents an edge from a vertex ai to a vertex bi.

You have to find the minimum number of edges you have to reverse in order to have atleast one path from vertex 1 to N, where the vertices are numbered from 1 to N.
*/

import java.io.*;
import java.util.*;

public class pepcoderAndReversing {

    private static class Edge {
        int vt, wt;

        Edge(int vt, int wt) {
            this.vt = vt;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt(), edges = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            int v1 = scn.nextInt() - 1, v2 = scn.nextInt() - 1;
            graph[v1].add(new Edge(v2, 0));
            graph[v2].add(new Edge(v1, 1));
        }
        scn.close();
        LinkedList<Edge> ll = new LinkedList<>();
        boolean[] visited = new boolean[vtces];
        ll.add(new Edge(0, 0));
        while (!ll.isEmpty()) {
            Edge rem = ll.removeFirst();
            if (visited[rem.vt])
                continue;
            visited[rem.vt] = true;
            if (rem.vt == vtces - 1) {
                System.out.println(rem.wt);
                return;
            }
            for (Edge e : graph[rem.vt]) {
                if (visited[e.vt])
                    continue;
                if (e.wt == 0)
                    ll.addFirst(new Edge(e.vt, rem.wt));
                else
                    ll.addLast(new Edge(e.vt, rem.wt + 1));
            }
        }
        System.out.println(-1);
    }
}
