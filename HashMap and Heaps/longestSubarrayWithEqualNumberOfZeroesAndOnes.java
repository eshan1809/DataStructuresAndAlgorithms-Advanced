/*
1. You are given an array that contains only 0s and 1s.
2. You have to find length of the longest subarray with equal number of 0s and 1s.
*/

import java.util.*;

public class longestSubarrayWithEqualNumberOfZeroesAndOnes {
    public static int solution(int[] arr) {
        // write your code here
        int zero = 0, one = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                one++;
            else
                zero++;
            int diff = one - zero;
            if (map.containsKey(diff))
                ans = Math.max(ans, i - map.get(diff));
            else
                map.put(diff, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(arr));
    }
}
