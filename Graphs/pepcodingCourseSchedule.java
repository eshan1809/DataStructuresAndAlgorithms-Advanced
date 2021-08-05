/*
Pepcoding offers total of n courses labelled from 0 to n-1.

Some courses may have prerequisites. you have been given m pairs ai,bi. where 1 pair means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses. If it is impossible to finish all courses print -1.
*/

import java.io.*;
import java.util.*;

public class pepcodingCourseSchedule {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt(), edges = scn.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < edges; i++) {
            int v1 = scn.nextInt(), v2 = scn.nextInt();
            graph[v2].add(v1);
        }
        scn.close();
        for (int i : getOrder(graph))
            System.out.print(i + " ");
    }

    private static int[] getOrder(ArrayList<Integer>[] graph) {
        int n = graph.length, idx = 0;
        int[] ans = new int[n], indegree = new int[n];
        for (int i = 0; i < n; i++)
            for (int nbr : graph[i])
                indegree[nbr]++;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            int rem = q.remove();
            ans[idx++] = rem;
            for (int nbr : graph[rem])
                if (--indegree[nbr] == 0)
                    q.add(nbr);
        }
        if (idx == n)
            return ans;
        return new int[] { -1 };
    }
}
