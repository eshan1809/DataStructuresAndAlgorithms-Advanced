/*
1. You are given an array of integers(arr) and a number K.
2. You have to find length of the longest subarray whose sum is divisible by K.
*/

import java.util.*;

public class longestSubarrayWithSumDivisibleByK {
    public static int solution(int[] arr, int k) {
        // write your code here
        int max = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = sum % k;
            if (rem < 0)
                rem += k;
            if (map.containsKey(rem)) {
                max = Math.max(max, i - map.get(rem));
            } else
                map.put(rem, i);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(arr, k));
    }
}
