/*
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the combinations of the n coins (same coin can be used again any number of times) using which the amount "amt" can be paid.
*/

import java.io.*;

public class CoinChangeCombinations2 {

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        if (amtsf >= tamt) {
            if (amtsf == tamt) {
                System.out.println(asf + ".");
            }
            return;
        }
        if (i == coins.length) {
            return;
        }
        coinChange(i, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
        coinChange(i + 1, coins, amtsf, tamt, asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
    }
}
