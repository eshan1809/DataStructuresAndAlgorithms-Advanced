/*
There are n houses numbered from 0 to n-1 connected by pipes forming a network where connections[i] = [a, b] represents a connection between houses a and b. 
Any house can reach any other house directly or indirectly through the network.

Given an initial pipeline network connections. You can extract certain pipes between two directly connected houses, 
and place them between any pair of disconnected houses to make them directly connected. 

Return the minimum number of times you need to do this in order to make all the houses connected. 
If it's not possible, return -1. 

Example 1:

Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove pipe between house 1 and 2 and place between houses 1 and 3.
*/

import java.util.*;

public class numberOfConnectionsToMakePipelineConnected {
    public static int makeConnected(int n, int[][] connections) {
        // Write your code here
        if (connections.length < n - 1)
            return -1;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int ans = n;
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0], v = connections[i][1];
            int lx = find(u), ly = find(v);
            if (lx != ly) {
                if (rank[lx] > rank[ly])
                    parent[ly] = lx;
                else if (rank[ly] > rank[lx])
                    parent[lx] = ly;
                else {
                    parent[lx] = ly;
                    rank[ly]++;
                }
                ans--;
            }
        }
        return ans - 1;
    }

    static int[] parent, rank;

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int numberOfHouses = scn.nextInt();

        int n = scn.nextInt();
        int[][] connections = new int[n][2];

        for (int i = 0; i < n; i++) {
            connections[i][0] = scn.nextInt();
            connections[i][1] = scn.nextInt();
        }
        scn.close();
        int ans = makeConnected(numberOfHouses, connections);
        System.out.println(ans);
    }
}
