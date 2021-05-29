/*
1. You are given an array(arr) of integers.
2. You have to find the count of all subarrays with sum 0.
*/

import java.util.*;

public class countOfAllSubarraysWithZeroSum {
    public static int solution(int[] arr) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int x = map.getOrDefault(sum, 0);
            count += x;
            map.put(sum, x + 1);
        }
        return count;
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