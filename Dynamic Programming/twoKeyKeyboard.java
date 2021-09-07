/*
1. You are given a number N.
2. You have to print exactly N number of 'X' on a notepad by performing the minimum number of operations.
3. Operations allowed are - 
   copyAll -> You can copy all the characters present on the notepad.
   Paste -> You can paste the last copied characters.
4. You have to find the minimum number of operations to get N 'X'.

Note -> Initially, one 'X' is present on the screen.
*/

import java.util.*;

public class twoKeyKeyboard {

	public static int solution(int n) {
		//write your code here
		int[] dp = new int[n + 1];
		for(int i = 2; i <= n; i++){
		    int min = i;
		    for(int j = 2; j <= i / 2; j++)
		        if(i % j == 0)
		            min = Math.min(min, dp[j] + i / j);
		    dp[i] = min;
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