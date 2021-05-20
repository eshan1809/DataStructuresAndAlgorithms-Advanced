/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
*/

import java.io.*;
import java.util.*;

public class nextGreaterElement2 {
    public static int[] nextGreaterElementII(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= nums[i])
                st.pop();
            st.push(nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= nums[i])
                st.pop();
            if (st.size() == 0)
                nge[i] = -1;
            else
                nge[i] = st.peek();
            st.push(nums[i]);
        }
        return nge;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(read.readLine());
        }

        int ans[] = nextGreaterElementII(nums);

        n = ans.length;

        System.out.println(n);
        for (int e : ans) {
            System.out.println(e);
        }

    }
}