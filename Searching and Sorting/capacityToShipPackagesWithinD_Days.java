/*
1. A conveyor belt has packages that must be shipped from one port to another within D days.
2. The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
3. Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
*/

import java.util.*;
import java.io.*;

public class capacityToShipPackagesWithinD_Days {

    public static int shipWithinDays(int[] weights, int D) {
        // write your code here
        int s = 0, m = 0;
        for (int i = 0; i < weights.length; i++) {
            s += weights[i];
            m = Math.max(weights[i], m);
        }
        int cap = Math.max((int) Math.ceil((double) s / D), m);
        while (true) {
            int sum = 0, count = 1;
            for (int i = 0; i < weights.length; i++) {
                if (sum + weights[i] > cap) {
                    count++;
                    sum = 0;
                }
                sum += weights[i];
                if (count > D) {
                    cap++;
                    break;
                }
            }
            if (count <= D)
                break;
        }
        return cap;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int days = scn.nextInt();
        scn.close();
        int ans = shipWithinDays(arr, days);
        System.out.println(ans);
    }
}