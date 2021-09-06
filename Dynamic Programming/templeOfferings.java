/*
1. Pepcoder is wishing to give offerings to all the temples along a mountain range. 
2. The temples are located in a row at different heights.
3. You have to find the minimum number of offerings such that these conditions are fulfilled - 
    -> If two adjacent temples are at different heights, then the temple which is situated at greater height should receive more offerings.
    -> If two adjacent temples are at the same height, then their offerings relative to each other does not matter.
*/

import java.util.*;

public class templeOfferings {

    public static int totaloffering(int[] height) {
        // write your code here
        int n = height.length, ans = 0;
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 1; i < n; i++)
            if (height[i] > height[i - 1])
                arr[i] = arr[i - 1] + 1;
            else
                arr[i] = 1;
        for (int i = n - 2; i >= 0; i--)
            if (height[i] > height[i + 1])
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
        for (int i = 0; i < n; i++)
            ans += arr[i];
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int height[] = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(totaloffering(height));
    }

}