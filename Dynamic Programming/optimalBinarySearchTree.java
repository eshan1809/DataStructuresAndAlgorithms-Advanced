/*
1. You are given two arrays - 
     The first array(keys), which is sorted and has distinct integers, represents search keys.
   Second one(freq) represents frequency counts, where freq[i] is the number of searches to keys[i].
2. A binary search tree is constructed containing all keys and the total cost of searches is minimum. 
3. The cost of a BST node is the level of that node multiplied by its frequency.
4. You have to find the minimum cost of all searches.
*/

import java.util.*;

public class optimalBinarySearchTree {

    private static void optimalbst(int[] keys, int[] frequency, int n) {
        // write your code here
        int[][] dp = new int[n][n];
        int[] pSum = new int[n];
        pSum[0] = frequency[0];
        for (int i = 1; i < n; i++)
            pSum[i] = pSum[i - 1] + frequency[i];
        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {
                if (k == 0)
                    dp[i][j] = frequency[i];
                else {
                    int min = Integer.MAX_VALUE, freq = pSum[j] - (i == 0 ? 0 : pSum[i - 1]);
                    for (int x = i; x <= j; x++) {
                        int left = (x == i ? 0 : dp[i][x - 1]), right = (x == j ? 0 : dp[x + 1][j]);
                        min = Math.min(min, left + right + freq);
                    }
                    dp[i][j] = min;
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            frequency[i] = scn.nextInt();
        }
        scn.close();
        optimalbst(keys, frequency, n);
    }

}