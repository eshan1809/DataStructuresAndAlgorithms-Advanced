/*
1. You are given an array of integers(arr).
2. You have to find the count of equivalent subarrays.
3. A subarray is equivalent if,
   count of unique integers in the subarray = count of unique integers in the given array.
*/

import java.util.*;

public class equivalentSubarrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        // write your code here
        Set<Integer> set = new HashSet<>();
        for (int i : arr)
            set.add(i);
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, i = 0, j = 0;
        while (true) {
            while (j < n && map.size() < set.size()) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                j++;
            }
            if (map.size() < set.size())
                break;
            while (map.size() == set.size()) {
                ans += n - j + 1;
                if (map.get(arr[i]) == 1)
                    map.remove(arr[i]);
                else
                    map.put(arr[i], map.get(arr[i]) - 1);
                i++;
            }
        }
        System.out.println(ans);
    }
}
