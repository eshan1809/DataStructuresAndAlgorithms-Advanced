/*
You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

For example, if routes[1] = [1, 5, 7], this means that the 1st bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.

You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
*/

import java.io.*;
import java.util.*;

class BusRoutes {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        String[] st1 = br.readLine().split(" ");
        int src = Integer.parseInt(st1[0]);
        int dest = Integer.parseInt(st1[1]);
        System.out.println(numBusesToDestination(arr, src, dest));

    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.putIfAbsent(routes[i][j], new ArrayList<>());
                map.get(routes[i][j]).add(i);
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> busvisited = new HashSet<>(), stopsvisited = new HashSet<>();
        int level = 0;
        q.add(S);
        stopsvisited.add(S);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int rem = q.remove();
                if (rem == T)
                    return level;
                for (int bus : map.get(rem)) {
                    if (!busvisited.contains(bus)) {
                        for (int stop : routes[bus]) {
                            if (!stopsvisited.contains(stop)) {
                                q.add(stop);
                                stopsvisited.add(stop);
                            }
                        }
                        busvisited.add(bus);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
