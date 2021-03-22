/*
 * 1. You are given a number n, representing the count of coins. 2. You are
 * given n numbers, representing the denominations of n coins. 3. You are given
 * a number "amt". 4. You are required to calculate and print the permutations
 * of the n coins (non-duplicate) using which the amount "amt" can be paid.
 */

import java.io.*;

public class CoinChangePermutations1 {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf, boolean[] used) {
        // write your code here
        if (amtsf >= tamt) { // if amount exceeds or no coin left
            if (amtsf == tamt)
                System.out.println(asf + "."); // if amount is equal to change
            return;
        }

        for (int i = 0; i < coins.length; i++) { // we can choose any coin at this level
            if (used[i] == false) { // only if it has not been chosen before
                used[i] = true; // mark it as chosen
                coinChange(coins, amtsf + coins[i], tamt, asf + coins[i] + "-", used); // next level
                used[i] = false; // undo while backtracking
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[coins.length];
        coinChange(coins, 0, amt, "", used);
    }
}