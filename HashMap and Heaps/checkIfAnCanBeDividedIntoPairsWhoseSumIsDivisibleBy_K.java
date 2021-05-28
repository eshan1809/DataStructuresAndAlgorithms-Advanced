/*
1. You are given an array(arr) of integers and a number K.
2. You have to find if the given array can be divided into pairs such that the sum of every pair is divisible by k.
*/

import java.util.*;

public class checkIfAnCanBeDividedIntoPairsWhoseSumIsDivisibleBy_K {
    public static void solution(int[] arr, int k) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.put(i % k, map.getOrDefault(i % k, 0) + 1);
        boolean flag = true;
        for (int i : map.keySet()) {
            if (i != 0 && map.get(i) != map.get(k - i)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
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
        solution(arr, k);
    }
}
