/*
1. Given n non-negative integers a1, a2, ..., an. 
2. Each represents a point at coordinate (i, ai). 
3. 'n' vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 
4. Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
5. (Not volume because we are working with 2D so amount of water is basically Area).
Note : that you may not slant the container.
*/

import java.util.*;

public class containerWithMostWater {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int mostWater(int[] heights) {
        // write your code here
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int idx1 = i, idx2 = i;
            for (int j = 0; j <= i; j++)
                if (heights[j] >= heights[i]) {
                    idx1 = j;
                    break;
                }
            for (int j = heights.length - 1; j >= i; j--)
                if (heights[j] >= heights[i]) {
                    idx2 = j;
                    break;
                }
            int area = (idx2 - idx1) * heights[i];
            if (area > max)
                max = area;
        }
        return max;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        // Write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }

        int res = mostWater(heights);
        System.out.println(res);
    }
}