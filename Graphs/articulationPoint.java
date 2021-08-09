/*
A vertex in an undirected graph is an articluation point iff removing it disconnects the graph. You have to find the number of articulation point in the given graph.
*/

import java.util.*;

class articulationPoint {
    static int[] parent, disc, low;
    static int time;
    static boolean[] vis, isAP;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt(), edges = scn.nextInt();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vtces; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < edges; i++) {
            int v1 = scn.nextInt() - 1, v2 = scn.nextInt() - 1;
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        scn.close();

        parent = new int[vtces];
        disc = new int[vtces];
        low = new int[vtces];
        time = 0;
        vis = new boolean[vtces];
        isAP = new boolean[vtces];

        parent[0] = -1;
        dfs(0, graph);

        int count = 0;
        for (boolean b : isAP)
            if (b)
                count++;

        System.out.println(count);
    }

    public static void dfs(int v, List<List<Integer>> graph) {
        disc[v] = low[v] = time;
        time++;
        vis[v] = true;

        int count = 0;
        List<Integer> nbrs = graph.get(v);
        for (int i = 0; i < nbrs.size(); i++) {
            int nbr = nbrs.get(i);
            if (parent[v] == nbr)
                continue;
            else if (vis[nbr])
                low[v] = Math.min(low[v], disc[nbr]);
            else {
                parent[nbr] = v;
                count++;
                dfs(nbr, graph);

                low[v] = Math.min(low[v], low[nbr]);
                if (parent[v] == -1) {
                    if (count >= 2)
                        isAP[v] = true;
                } else {
                    if (low[nbr] >= disc[v])
                        isAP[v] = true;
                }
            }
        }
    }
}
