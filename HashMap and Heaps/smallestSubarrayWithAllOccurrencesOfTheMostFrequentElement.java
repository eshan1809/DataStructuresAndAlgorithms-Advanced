/*
1. You are given an array(arr) of integers.
2. You have to find the element(x) with maximum frequency in the given array. 
3. Also, you have to find the smallest subarray which has all occurrences of the most frequent element i.e x.

Note -> If there are two or more elements with maximum frequency and the same subarray size then print the subarray which occurs first in the given array.
*/

import java.util.*;

public class smallestSubarrayWithAllOccurrencesOfTheMostFrequentElement {
    public static class Pair {
        int freq, si, ei;

        Pair(int x, int y, int z) {
            freq = x;
            si = y;
            ei = z;
        }
    }

    public static void solution(int[] arr) {
        // write your code here
        Map<Integer, Pair> map = new HashMap<>();
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                Pair p = map.get(arr[i]);
                p.freq++;
                p.ei = i;
                map.put(arr[i], p);
            } else {
                map.put(arr[i], new Pair(1, i, i));
            }
            if (map.get(arr[i]).freq > map.get(max).freq)
                max = arr[i];
            else if (map.get(arr[i]).freq == map.get(max).freq) {
                Pair p1 = map.get(arr[i]), p2 = map.get(max);
                if (p1.ei - p1.si < p2.ei - p2.si || (p1.ei - p1.si == p2.ei - p2.si && p1.si < p2.si))
                    max = arr[i];
            }
        }
        System.out.println(max + "\n" + map.get(max).si + "\n" + map.get(max).ei);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        solution(arr);
    }
}
