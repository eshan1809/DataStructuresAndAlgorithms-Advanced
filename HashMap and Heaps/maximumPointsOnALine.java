/*
1. You are given a 2-D array of integers where every row represents x and y co-ordinate of a point on a 2-D plane.
2. You have to find the maximum number of points that lie on the same straight line.
*/

import java.util.*;

public class maximumPointsOnALine {
    public static int solution(int[][] points) {
        // write your code here
        int n = points.length, max = 1;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                double slope = ((points[j][1] - points[i][1]) * 1.0) / ((points[j][0] - points[i][0]) * 1.0);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
            }
            for (double d : map.keySet())
                max = Math.max(max, map.get(d));
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();
        System.out.println(solution(arr));
    }
}
