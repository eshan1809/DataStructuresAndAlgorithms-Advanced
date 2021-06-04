/*
1. You are given an array of integers(arr) and a number K.
2. You have to find the count of subarrays whose sum is divisible by K.
*/

import java.util.*;

public class countOfSubarraysWithSumDivisibleByK {
    public static int solution(int[] arr, int k) {
        // write your code here
        int sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : arr) {
            sum += i;
            int rem = sum % k;
            if (rem < 0)
                rem += k;
            int x = map.getOrDefault(rem, 0);
            ;
            ans += x;
            map.put(rem, x + 1);
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
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(arr, k));
    }

}
