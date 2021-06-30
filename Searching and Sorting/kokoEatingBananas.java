/*
1. Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
2. Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
3. Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
4. Return the minimum integer k such that she can eat all the bananas within h hours.
*/

import java.util.*;

public class kokoEatingBananas {
    public static int check(int[] piles, int m) {
        int ans = 0;
        for (int i : piles)
            ans += (int) Math.ceil((double) i / m);
        return ans;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        // write your code here
        int k = Integer.MAX_VALUE, lo = 0, hi = 0;
        for (int i = 0; i < piles.length; i++)
            hi = Math.max(hi, piles[i]);
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(piles, mid) <= h) {
                k = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // input work
        int n = scn.nextInt();
        int[] piles = new int[n];

        for (int i = 0; i < n; i++) {
            piles[i] = scn.nextInt();
        }

        int h = scn.nextInt();
        scn.close();
        int speed = minEatingSpeed(piles, h);
        System.out.println(speed);
    }
}