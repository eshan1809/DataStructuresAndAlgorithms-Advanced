/*
1. Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
2. Every house can be warmed, as long as the house is within the heater's warm radius range. 
3. Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
4. Notice that all the heaters follow your radius standard, and the warm radius will the same.
*/

import java.util.*;
import java.io.*;

public class heaters {
    public static int findRadius(int[] houses, int[] heaters) {
        // write your code here
        Arrays.sort(heaters);
        int ans = 0, n = heaters.length;
        for (int i = 0; i < houses.length; i++) {
            int lo = 0, hi = n - 1, left = -1, right = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (heaters[mid] == houses[i]) {
                    left = heaters[mid];
                    break;
                } else if (heaters[mid] < houses[i]) {
                    left = heaters[mid];
                    lo = mid + 1;
                } else
                    hi = mid - 1;
            }
            lo = 0;
            hi = n - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (heaters[mid] == houses[i]) {
                    right = heaters[mid];
                    break;
                } else if (heaters[mid] > houses[i]) {
                    right = heaters[mid];
                    hi = mid - 1;
                } else
                    lo = mid + 1;
            }
            if (left == -1)
                ans = Math.max(ans, right - houses[i]);
            else if (right == -1)
                ans = Math.max(ans, houses[i] - left);
            else
                ans = Math.max(ans, Math.min(houses[i] - left, right - houses[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[] heaters = new int[m];

        for (int i = 0; i < m; i++) {
            heaters[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(findRadius(houses, heaters));
    }
}