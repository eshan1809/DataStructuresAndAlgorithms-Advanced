/*
Given an array nums of integers, return the number of non-empty continuous subarrays that satisfy the following condition:
The leftmost element of the subarray is not larger than other elements in the subarray.
*/

import java.io.*;
import java.util.*;

public class numberOfValidSubarrays {
    public static int validSubarrays(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length, ans = 0;
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && nums[st.peek()] >= nums[i])
                st.pop();
            if (st.size() == 0)
                nse[i] = n - 1;
            else
                nse[i] = st.peek() - 1;
            st.push(i);
            ans += nse[i] - i + 1;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(read.readLine());
        }

        int count = validSubarrays(nums);

        System.out.println(count);

    }
}
