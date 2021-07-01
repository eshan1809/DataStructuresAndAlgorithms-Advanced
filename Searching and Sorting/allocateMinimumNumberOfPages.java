/*
1. You are given N number of books. Every ith book has Ai number of pages. 
2. You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value. 
3. Each book will be allocated to exactly one student. Each student has to be allocated at least one book.
4. Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order.
*/

import java.util.*;
import java.io.*;

public class allocateMinimumNumberOfPages {

    public static int minPages(int[] arr, int m) {
        // write your code here
        int sum = 0, max = 0;
        for (int i : arr) {
            sum += i;
            max = Math.max(max, i);
        }
        int lo = max, hi = sum, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int load = 0, student = 0;
            for (int i : arr) {
                if (load + i <= mid)
                    load += i;
                else {
                    student++;
                    load = i;
                }
            }
            if (student < m) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        scn.close();
        int ans = minPages(arr, m);
        System.out.println(ans);
    }
}