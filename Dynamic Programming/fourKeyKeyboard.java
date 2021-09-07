/*
1. Imagine you have a special keyboard with the following keys - 
   Key 1 : Print 'X' on the screen.
   key 2 : Select screen.
   Key 3 : Copy selection to buffer.
   Key 4 : Print buffer on screen appending to what has already been printed.
2. You are given a number N, which represents the number of times the keyboard is pressed.
3. You have to find the maximum number of 'X' that can be produced by pressing the N number of keys.
*/

import java.util.*;

public class fourKeyKeyboard {

    public static int solution(int n) {
        // write your code here
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i - 2; j++)
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        System.out.println(solution(n));
    }

}