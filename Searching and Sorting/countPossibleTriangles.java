/*
Given an unsorted array arr[] of n positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles. 
*/

import java.util.*;

public class countPossibleTriangles {

    public static int countTriangles(int[] arr) {
        // write your code here
        Arrays.sort(arr);
        int n = arr.length, count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int lo = j + 1, hi = n - 1, pans = j;
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    if (arr[mid] < arr[i] + arr[j]) {
                        pans = mid;
                        lo = mid + 1;
                    } else
                        hi = mid - 1;
                }
                count += (pans - j);
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
        System.out.println(countTriangles(arr));
    }
}