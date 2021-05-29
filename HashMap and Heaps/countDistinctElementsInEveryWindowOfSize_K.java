/*
1. You are given an array(arr) of integers and a number K.
2. You have to find the count of distinct numbers in all windows of size k.
*/

import java.util.*;

public class countDistinctElementsInEveryWindowOfSize_K {
    public static ArrayList<Integer> solution(int[] arr, int k) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        for (int i = k - 1; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            list.add(map.size());
            if (map.get(arr[i - k + 1]) == 1)
                map.remove(arr[i - k + 1]);
            else
                map.put(arr[i - k + 1], map.get(arr[i - k + 1]) - 1);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();
        ArrayList<Integer> ans = solution(arr, k);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}
