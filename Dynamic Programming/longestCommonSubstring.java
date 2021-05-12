/*
1. You are given two strings S1 and S2.
2. You are required to print the length of the longest common substring of two strings.
*/

import java.io.*;
import java.util.*;

public class longestCommonSubstring {

	public static int solution(String s1, String s2) {
		// write your code here
		int n = s1.length(), m = s2.length(), max = 0;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
		return max;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}