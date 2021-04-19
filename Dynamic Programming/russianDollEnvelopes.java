/*
1. You are given a number n, representing the number of envelopes.
2. You are given n pair of numbers, representing the width and height of each envelope.
3. You are required to print the count of maximum number of envelopes that can be nested inside each other.
*/

import java.util.*;

public class russianDollEnvelopes {
    static class Pair implements Comparable<Pair> {
        int first, second; // first/second -> first/second length, breadth of envelope

        Pair(int f, int s) {
            first = f;
            second = s;
        }

        public int compareTo(Pair o) {
            if (this.first != o.first)
                return this.first - o.first; // sorting on basis of length (increasingly)
            else
                return this.second - o.second;
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        if (n == 0) {
            System.out.println(0);
            scn.close();
            return;
        }
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int f = scn.nextInt(), s = scn.nextInt();
            pairs[i] = new Pair(f, s);
        }
        scn.close();
        Arrays.sort(pairs);

        // longest increasing subsequence
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int lmax = 0;
            for (int j = 0; j < i; j++) {
                if (pairs[i].second > pairs[j].second && pairs[i].first > pairs[j].first) {
                    lmax = Math.max(lmax, dp[j]);
                }
            }
            dp[i] = lmax + 1;
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
