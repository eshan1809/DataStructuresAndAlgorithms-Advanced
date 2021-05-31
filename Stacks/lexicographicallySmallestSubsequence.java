/*
1. Given an integer array nums and a positive integer k
2. return the lexicographically smallest subsequence of size k
*/

import java.io.*;
import java.util.*;

public class lexicographicallySmallestSubsequence {
    public static int[] smallest(int[] nums, int k) {
        // write your code here
        int[] ans = new int[k];
        int rem = nums.length - k;
        Stack<Integer> st = new Stack<>();
        for (int num : nums) {
            while (st.size() > 0 && st.peek() > num & rem > 0) {
                st.pop();
                rem--;
            }
            st.push(num);
        }
        while (rem-- > 0)
            st.pop();
        while (st.size() > 0)
            ans[--k] = st.pop();
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(read.readLine());
        int k = Integer.parseInt(read.readLine());
        int ans[] = smallest(arr, k);
        System.out.println(ans.length);

        for (int e : ans) {
            System.out.println(e);
        }

    }
}
