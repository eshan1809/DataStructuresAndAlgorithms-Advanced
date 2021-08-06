/*
You are given a graph with N nodes and M directed edges. Find the number of Strongly connected components in the graph.
*/

import java.util.*;

public class KosarajuAlgorithm {
    public static void main(String args[]) throws Exception {
        Scanner scn = new Scanner(System.in);

        int vtces = scn.nextInt(), edges = scn.nextInt();

        List<Integer>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < edges; i++)
            graph[scn.nextInt() - 1].add(scn.nextInt() - 1);

        scn.close();
        System.out.println(countOfStronglyConnectedComponents(graph));
    }

    private static int countOfStronglyConnectedComponents(List<Integer>[] graph) {
        int n = graph.length;
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++)
            if (!visited[i])
                fillStackDFS(graph, i, st, visited);

        List<Integer>[] graph2 = reverseEdges(graph);

        return getConnectedComponents(graph2, st);
    }

    private static void fillStackDFS(List<Integer>[] graph, int i, Stack<Integer> st, boolean[] visited) {
        if (visited[i])
            return;

        visited[i] = true;

        for (int nbr : graph[i])
            fillStackDFS(graph, nbr, st, visited);

        st.push(i);
    }

    private static List<Integer>[] reverseEdges(List<Integer>[] graph) {
        int n = graph.length;
        List<Integer>[] graph2 = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph2[i] = new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int v : graph[i])
                graph2[v].add(i);

        return graph2;
    }

    private static int getConnectedComponents(List<Integer>[] graph, Stack<Integer> st) {
        int n = graph.length, count = 0;
        boolean[] visited = new boolean[n];

        while (!st.isEmpty()) {
            int rem = st.pop();
            if (visited[rem])
                continue;
            dfs(graph, rem, visited);
            count++;
        }

        return count;
    }

    private static void dfs(List<Integer>[] graph, int i, boolean[] visited) {
        if (visited[i])
            return;
        visited[i] = true;
        for (int nbr : graph[i])
            dfs(graph, nbr, visited);
    }
}
