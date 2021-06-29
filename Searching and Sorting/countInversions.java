/*
1. Given an array of integers. Find the Inversion Count in the array. 
2. For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
3. Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
*/

import java.util.*;

public class countInversions {
    static int ans;

    public static int[] merge2SortedArrays(int[] left, int[] right) {
        int n = left.length, m = right.length, i = 0, j = 0, k = 0;
        int[] merged = new int[n + m];
        while (i < n && j < m) {
            if (left[i] < right[j])
                merged[k++] = left[i++];
            else {
                ans += n - i;
                merged[k++] = right[j++];
            }
        }
        while (i < n)
            merged[k++] = left[i++];
        while (j < m)
            merged[k++] = right[j++];
        return merged;
    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            int[] res = new int[1];
            res[0] = arr[start];
            return res;
        }
        int mid = (start + end) / 2;
        int[] left = mergeSort(arr, start, mid), right = mergeSort(arr, mid + 1, end);
        int[] merged = merge2SortedArrays(left, right);
        return merged;
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
        scn.close();
        ans = 0;
        mergeSort(arr, 0, n - 1);
        System.out.println(ans);
    }
}