/*
1. You are given an array that contains only 0s, 1s, and 2s.
2. You have to find length of the longest subarray with equal number of 0s, 1s, and 2s.
*/

import java.util.*;

public class longestSubarrayWithEqualNumberOf0s1sAnd2s {
    public static int solution(int[] arr) {
        // write your code here
        int zero = 0, one = 0, two = 0, ans = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2)
                two++;
            else if (arr[i] == 1)
                one++;
            else
                zero++;
            String str = (zero - one) + "#" + (one - two);
            if (map.containsKey(str))
                ans = Math.max(ans, i - map.get(str));
            else
                map.put(str, i);
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
