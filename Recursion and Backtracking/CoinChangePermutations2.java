/*
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the permutations of the n coins (same coin can be used again any number of times) using which the amount "amt" can be paid.
*/

import java.io.*;

public class CoinChangePermutations2 {
    public static void coinChange(int[] coins, int amtsf, int tamt, String asf) {
        if (amtsf >= tamt) { // if amount exceeds or no coin left
            if (amtsf == tamt)
                System.out.println(asf + "."); // if amount is equal to change
            return;
        }

        for (int i = 0; i < coins.length; i++) { // we can choose any coin at this level
            coinChange(coins, amtsf + coins[i], tamt, asf + coins[i] + "-"); // next level
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(coins, 0, amt, "");
    }
}
