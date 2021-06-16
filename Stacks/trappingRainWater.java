/*
1. Given n non-negative integers representing an elevation map where the width of each bar is 1.
2. Compute how much water it can trap after raining.
*/

import java.io.*;

public class trappingRainWater {
    public static int trap(int[] height) {
        int n = height.length, max = 0, ans = 0;
        int[] maxL = new int[n], maxR = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            maxL[i] = max;
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            maxR[i] = max;
        }
        for (int i = 0; i < n; i++)
            ans += Math.min(maxL[i], maxR[i]) - height[i];
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(read.readLine());
        int result = trap(arr);
        System.out.println(result);

    }
}
