/*
Ishaan has a craving for sticks. He has N sticks. He observes that some of his sticks are of the same length, and thus he can make squares out of those.
He wants to know how big a square he can make using those sticks as sides. Since the number of sticks is large, he can't do that manually. Can you tell him the maximum area of the biggest square that can be formed?
Also, calculate how many such squares can be made using the sticks.

Constraints-
    1 <= N <= 10^5
    1 <= arr[i] <= 10^3
*/

import java.util.*;

public class ishaanAndSticks {

    public static ArrayList<Integer> solve(int[] arr) {
        int[] dp = new int[1001];
        for (int i : arr)
            dp[i]++;
        int area = 0, nos = 0;
        for (int i = 1000; i > 0; i--) {
            if (dp[i] >= 4) {
                area = i * i;
                nos = dp[i] / 4;
                break;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(area);
        list.add(nos);
        return list;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        ArrayList<Integer> ans = solve(arr);

        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}