/*
1. You are given an array of integers, which represents the vertices of an N-sided convex polygon in clockwise order.
2. You have to triangulate the given polygon into N-2 triangles.
3. The value of a triangle is the product of the labels of vertices of that triangle.
4. The total score of the triangulation is the sum of the value of all the triangles.
5. You have to find the minimum score of the triangulation of the given polygon.
*/

import java.util.*;

public class minimumScoreOfTriangulation {
    public static int minScoreTriangulation(int[] arr) {
        // write your code here
        if (arr.length < 3)
            return 0;
        int[][] dp = new int[arr.length][arr.length];
        for (int k = 2; k < arr.length; k++) {
            for (int i = 0, j = k; j < arr.length; i++, j++) {
                int min = Integer.MAX_VALUE, val = arr[i] * arr[j];
                for (int x = i + 1; x < j; x++)
                    min = Math.min(min, val * arr[x] + dp[i][x] + dp[x][j]);
                dp[i][j] = min;
            }
        }
        return dp[0][arr.length - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(minScoreTriangulation(arr));
    }
}
