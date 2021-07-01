/*
Given a sorted array of size N. Count the number of distinct absolute values present in the array.
*/

import java.util.*;
import java.io.*;

public class distinctAbsoluteArrayElements {

    public static int count(int[] arr) {
        // write your code here
        int count = 0;
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int left = Math.abs(arr[lo]), right = Math.abs(arr[hi]);
            count++;
            if (left >= right) {
                while (lo + 1 <= hi && Math.abs(arr[lo + 1]) == left)
                    lo++;
                lo++;
            }
            if (right >= left) {
                while (hi - 1 >= lo && Math.abs(arr[hi - 1]) == right)
                    hi--;
                hi--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(count(arr));
    }
}