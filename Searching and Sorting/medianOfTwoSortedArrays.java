/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
*/

import java.util.*;

public class medianOfTwoSortedArrays {

    public static double find2(int[] nums1, int[] nums2) {
        // write your code here
        int n1 = nums1.length, n2 = nums2.length, lo = 0, hi = n1, noe = n1 + n2;
        while (lo <= hi) {
            int aleft = (lo + hi) / 2, bleft = (noe + 1) / 2 - aleft;
            // valid segreagation
            if ((bleft >= n2 || aleft <= 0 || nums1[aleft - 1] <= nums2[bleft])
                    && (aleft >= n1 || bleft <= 0 || nums1[aleft] >= nums2[bleft - 1])) {
                if (noe % 2 == 0)
                    return (double) (Math.max(nums1[aleft - 1], nums2[bleft - 1])
                            + Math.min(nums1[aleft], nums2[bleft])) / 2;
                else
                    return (double) Math.max(nums1[aleft - 1], nums2[bleft - 1]);
            } else if (nums1[aleft - 1] > nums2[bleft])
                hi = aleft - 1;
            else
                lo = aleft + 1;
        }
        return 0;
    }

    public static double find1(int[] nums1, int[] nums2) {
        // write your code here
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length)
            if (nums1[i] < nums2[j])
                arr[k++] = nums1[i++];
            else
                arr[k++] = nums2[j++];
        while (i < nums1.length)
            arr[k++] = nums1[i++];
        while (j < nums2.length)
            arr[k++] = nums2[j++];
        if (arr.length % 2 == 1)
            return (double) arr[arr.length / 2];
        else
            return (double) (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // input work
        int n1 = scn.nextInt();
        int[] a = new int[n1];

        for (int i = 0; i < n1; i++) {
            a[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] b = new int[n2];

        for (int i = 0; i < n2; i++) {
            b[i] = scn.nextInt();
        }
        scn.close();
        // double median = find1(a, b); // Space -> O(n) Time -> O(n)
        double median = find2(a, b); // Space -> O(1) Time -> O(log(n))
        System.out.println(median);
    }
}