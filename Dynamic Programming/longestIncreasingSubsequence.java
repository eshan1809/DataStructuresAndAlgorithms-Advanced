import java.util.*;

public class longestIncreasingSubsequence {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(), max = 0;
        int[] arr = new int[n], dp = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int lMax = 0;
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i])
                    lMax = Math.max(lMax, dp[j]);
            dp[i] = lMax + arr[i];
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        scn.close();
    }
}