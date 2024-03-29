/*
1. Given an array arr that is a permutation of [0, 1, ..., arr.length - 1].
2. We split the array into some number of "chunks" (partitions), and individually sort each chunk. 
3. Shuffling of chunk is not allowed.
4. After concatenating them, the result equals the sorted array.
5. What is the most number of chunks we could have made?
*/

import java.util.*;

public class maxChunksToMakeArraySorted {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted(int[] arr) {
        // write your code here
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                ans++;
        }
        return ans;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        int res = maxChunksToSorted(arr);
        System.out.println(res);
    }
}