/*
1. You are given an array(arr) of integers.
2. You have to find the length of the largest subarray with sum 0.
*/

import java.util.*;

class largestSubarrayWithZeroSum {
	public static int solution(int[] arr) {
		// write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0, ans = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum))
				ans = Math.max(ans, i - map.get(sum));
			else
				map.put(sum, i);
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		scn.close();
		System.out.println(solution(arr));
	}
}
