/*
1. Given an array arr of size n, you need to write a program to find if there exists a pair of elements in the array whose difference is equals to target.
2. If there exists such a pair print it, otherwise print -1.
*/

import java.util.*;

public class findPairWithGivenDifference {

    public static void findPair(int[] arr, int target) {
        // write your code here
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int x = Arrays.binarySearch(arr, target + arr[i]);
            if (x >= 0 && x < arr.length) {
                System.out.println(arr[i] + " " + arr[x]);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {

        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        findPair(arr, target);
        scn.close();
    }
}