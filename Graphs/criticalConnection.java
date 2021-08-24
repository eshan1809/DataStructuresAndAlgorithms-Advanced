/*
An edge in an undirected graph is a Bridge iff removing it disconnects the graph. You have to print all the Bridges of the given graph.
*/

import java.util.*;
import java.io.*;

class criticalConnection {

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> Edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < Edges.size(); i++) {
            graph[Edges.get(i).get(0)].add(Edges.get(i).get(1));
            graph[Edges.get(i).get(1)].add(Edges.get(i).get(0));
        }

        time = 0;
        low = new int[n];
        dis = new int[n];
        parent = new int[n];
        visited = new boolean[n];

        List<List<Integer>> ans = new ArrayList<>();
        bridges(0, graph, ans);
        return ans;
    }

    static boolean[] visited;
    static int[] parent, low, dis;
    static int time;

    public static void bridges(int src, List<Integer>[] graph, List<List<Integer>> ans) {
        dis[src] = low[src] = time;
        time++;
        visited[src] = true;
        for (int nbr : graph[src]) {
            if (parent[src] == nbr)
                continue;
            else if (visited[nbr]) {
                low[src] = Math.min(low[src], dis[nbr]);
            } else {
                parent[nbr] = src;
                bridges(nbr, graph, ans);
                low[src] = Math.min(low[src], low[nbr]);
                if (low[nbr] > dis[src]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(src);
                    list.add(nbr);
                    ans.add(list);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            edges.add(new ArrayList<>());
            st = br.readLine().split(" ");
            edges.get(i).add(Integer.parseInt(st[0]));
            edges.get(i).add(Integer.parseInt(st[1]));
        }

        System.out.println(criticalConnections(n, edges));

    }

}