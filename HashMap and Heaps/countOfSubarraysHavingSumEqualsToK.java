/*
1. You are given an array of integers(arr) and a number K.
2. You have to find the count of subarrays whose sum equals k.
*/

import java.util.*;

public class countOfSubarraysHavingSumEqualsToK {
    public static int solution(int[] arr, int target) {
        // write your code here
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans += map.getOrDefault(sum - target, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
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
        int target = scn.nextInt();
        scn.close();
        System.out.println(solution(arr, target));
    }
}
