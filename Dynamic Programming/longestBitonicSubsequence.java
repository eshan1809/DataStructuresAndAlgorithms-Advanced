/*
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest bitonic subsequence of array.
Note -> bitonic subsequence begins with elements in increasing order, followed by elements in decreasing order.
*/

import java.util.*;

public class longestBitonicSubsequence {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n], dp1 = new int[n], dp2 = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
        scn.close();
        if (n <= 2) {
            System.out.println(n);
            return;
        }
        dp1[0] = 1;
        dp2[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i])
                    max = Math.max(max, dp1[j]);
            dp1[i] = max + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            int max = 0;
            for (int j = n - 1; j > i; j--)
                if (arr[j] < arr[i])
                    max = Math.max(max, dp2[j]);
            dp2[i] = max + 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dp1[i] + dp2[i]);
        System.out.println(max - 1);
    }
}
