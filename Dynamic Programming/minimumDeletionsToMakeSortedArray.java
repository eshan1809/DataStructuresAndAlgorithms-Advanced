/*
1. You are given a number N representing number of elements.
2. You are given N space separated numbers representing (ELE)elements.
3. Find the minimum number of deletions/removals needed such that remaining elements are (strictly)sorted.
*/

import java.util.Scanner;

public class minimumDeletionsToMakeSortedArray {
    public static int minimumDeletionsToSorted(int[] arr) {
        // write your code here
        int n = arr.length, max1 = 1, max2 = 1;
        int[] dp1 = new int[n], dp2 = new int[n];
        dp2[0] = dp1[0] = 1;
        for (int i = 1; i < n; i++) {
            int lMax = 0;
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i])
                    lMax = Math.max(lMax, dp1[j]);
            dp1[i] = lMax + 1;
            max1 = Math.max(max1, lMax + 1);
        }
        for (int i = 1; i < n; i++) {
            int lMax = 0;
            for (int j = 0; j < i; j++)
                if (arr[j] > arr[i])
                    lMax = Math.max(lMax, dp2[j]);
            dp2[i] = lMax + 1;
            max2 = Math.max(max2, lMax + 1);
        }
        return n - Math.max(max1, max2);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(minimumDeletionsToSorted(arr));
    }
}