/*
1. A group of two or more people wants to meet and minimize the total travel distance.
2. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
3. Return min distance where distance is calculated using 'Manhattan Distance', where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
*/

import java.util.*;

public class bestMeetingPoint {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static int minTotalDistance(int[][] grid) {
        // Write your code here
        int n = grid.length, m = grid[0].length;
        ArrayList<Integer> alx = new ArrayList<>(), aly = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    alx.add(i);
        for (int j = 0; j < m; j++)
            for (int i = 0; i < n; i++)
                if (grid[i][j] == 1)
                    aly.add(j);
        int x = alx.get(alx.size() / 2), y = aly.get(aly.size() / 2), ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    ans += Math.abs(i - x) + Math.abs(j - y);
        return ans;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }
        scn.close();
        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}