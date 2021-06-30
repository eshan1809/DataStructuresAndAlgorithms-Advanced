/*
1. Given a sorted array containing only 0s and 1s, find the transition point.
2. Transition Point is defined as 1's starting point.
3. If there is no transition point, return -1.
*/

import java.util.*;

public class findTransitionPoint {

    public static int findTransition(int[] arr) {
        // write your code here
        int lo = 0, hi = arr.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == 1) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(findTransition(arr));
    }
}