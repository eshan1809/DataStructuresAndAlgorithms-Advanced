/*
Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].
*/

import java.util.*;

public class countingElementsInTwoArrays {

    public static int[] find(int[] arr1, int[] arr2) {
        // write your code here
        Arrays.sort(arr2);
        int n = arr1.length, m = arr2.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = m - 1, pans = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (arr2[mid] <= arr1[i]) {
                    pans = mid;
                    lo = mid + 1;
                } else
                    hi = mid - 1;
            }
            ans[i] = pans + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);

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
        int[] ans = find(a, b);

        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}