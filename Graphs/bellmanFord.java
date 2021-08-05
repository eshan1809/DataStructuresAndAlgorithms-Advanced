/*
You are given 2 integers N and M , N is the number of vertices, M is the number of edges. You'll also be given ai, bi and wi where ai and bi represents an edge from a vertex ai to a vertex bi and wi respresents the weight of that edge.
Your task is to find the shortest path from source vertex (vertex number 1) to all other vertices.

Note : use bellman ford algo.
*/

import java.util.*;

public class bellmanFord {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), m = scn.nextInt();

        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            int v1 = scn.nextInt(), v2 = scn.nextInt(), w = scn.nextInt();
            arr[i][0] = v1 - 1;
            arr[i][1] = v2 - 1;
            arr[i][2] = w;
        }
        scn.close();

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int v1 = arr[j][0], v2 = arr[j][1], w = arr[j][2];
                if (ans[v1] == Integer.MAX_VALUE)
                    continue;
                if (ans[v1] + w < ans[v2])
                    ans[v2] = ans[v1] + w;
            }
        }

        for (int i = 1; i < n; i++)
            System.out.print(Math.min(ans[i], 1000000000) + " ");
    }
}
