/*
1. Given an array arr of integers (not necessarily distinct).
2. We split the array into some number of "chunks" (partitions), and individually sort each chunk.  
3. After concatenating them, the result equals the sorted array.
4. What is the most number of chunks we could have made?
*/

import java.util.*;

public class maxChunksToMakeArraySorted2 {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        // write your code here
        int n = arr.length, count = 0;
        int[] lmax = new int[n], rmin = new int[n + 1];
        lmax[0] = arr[0];
        rmin[n] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++)
            lmax[i] = Math.max(lmax[i - 1], arr[i]);
        for (int i = n - 1; i >= 0; i--)
            rmin[i] = Math.min(rmin[i + 1], arr[i]);
        for (int i = 0; i < n; i++)
            if (lmax[i] <= rmin[i + 1])
                count++;
        return count;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}