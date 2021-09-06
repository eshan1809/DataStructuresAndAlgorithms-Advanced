/*
1. You are given an array(arr) of integers.
2. You have to find the count of arithmetic slices in the given array.
3. Arithmetic slice is defined as the sub-sequence of an array having all its elements in A.P and length of sub-sequence should be greater than or equal to 3.
*/

import java.util.*;

public class arithmeticSlices2 {

    public static int solution(int[] arr) {
        // write your code here
        int ans = 0, n = arr.length;
        Map<Integer, Integer>[] map = new HashMap[n];
        for (int i = 0; i < n; i++)
            map[i] = new HashMap<>();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) arr[i] - (long) arr[j];
                if (Integer.MIN_VALUE < diff && diff < Integer.MAX_VALUE) {
                    int cd = (int) diff;
                    ans += map[j].getOrDefault(cd, 0);
                    map[i].put(cd, map[i].getOrDefault(cd, 0) + map[j].getOrDefault(cd, 0) + 1);
                }
            }
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