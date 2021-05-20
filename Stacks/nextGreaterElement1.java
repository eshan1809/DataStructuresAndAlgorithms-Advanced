/*
1: You are given two integer arrays query and nums containing unique elements.
2: Here query is a subset of nums that means all elements of query are also present in nums.
3: Find all the next greater numbers for query's elements in the corresponding places of nums. If it does not exist -1 is answer for this number.
4: You are required to complete the body of the function nextGreaterI(int nums[], int query[]) which returns the answer array containing next greater element's.
*/

import java.io.*;
import java.util.*;

public class nextGreaterElement1 {
    public static int[] nextGreaterElement(int[] nums, int[] query) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= nums[i])
                st.pop();
            if (st.size() == 0)
                map.put(nums[i], -1);
            else
                map.put(nums[i], st.peek());
            st.push(nums[i]);
        }
        int[] ret = new int[query.length];
        for (int i = 0; i < ret.length; i++)
            ret[i] = map.get(query[i]);
        return ret;
    }

    public static int[] getArr(String s) {
        String nums[] = s.split(" ");
        int n = nums.length;
        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(nums[i]);
        }
        return ar;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int query[] = getArr(read.readLine());
        int nums[] = getArr(read.readLine());

        int ans[] = nextGreaterElement(nums, query);

        int n = ans.length;

        System.out.println(n);
        for (int e : ans) {
            System.out.println(e);
        }

    }
}