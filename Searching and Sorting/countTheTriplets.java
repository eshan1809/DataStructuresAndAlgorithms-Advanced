/*
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
*/

import java.util.*;

public class countTheTriplets {

    public static int countTriplets(int[] arr) {
        // write your code here
        Arrays.sort(arr);
        int n = arr.length, count = 0;
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] == arr[k]) {
                    count++;
                    i++;
                    j--;
                } else if (arr[i] + arr[j] < arr[k])
                    i++;
                else
                    j--;
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
        System.out.println(countTriplets(arr));
    }
}