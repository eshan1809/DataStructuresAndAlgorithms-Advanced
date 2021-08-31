/*
1. Given an integer array nums.
2. Partition it into two (contiguous) subarrays left and right so that:
    a. Every element in left is less than or equal to every element in right.
    b. Left and right are non-empty.
    c. Left has the smallest possible size.
3. Return the length of left after such a partitioning.
NOTE : Test cases are generated such that partitioning exists.
*/

import java.util.*;

public class partitionArrayIntoDisjointIntervals {

    // ~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~
    public static int partitionDisjoint(int[] arr) {
        // write your code here
        int n = arr.length;
        int[] maxLeft = new int[n], minRight = new int[n];
        maxLeft[0] = arr[0];
        for (int i = 1; i < n; i++)
            maxLeft[i] = Math.max(arr[i], maxLeft[i - 1]);
        minRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            minRight[i] = Math.min(arr[i], minRight[i + 1]);
        for (int i = 1; i < n; i++)
            if (maxLeft[i - 1] <= minRight[i])
                return i;
        return n;
    }

    // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        int len = partitionDisjoint(arr);
        System.out.println(len);
    }
}