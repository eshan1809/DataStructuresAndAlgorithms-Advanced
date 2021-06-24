/*
1. Given an integer array of size 'n'.
2. Find all elements that appear more than n / 3 times and return it in an arraylist.
3. Note : solve the problem in linear time and in O(1) space.
*/

import java.util.*;

public class majorityElements2 {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement2(int[] nums) {
        // write your code here
        Integer val1 = null, val2 = null, n = nums.length;
        int count1 = 0, count2 = 0;
        for (int i : nums) {
            if (val1 != null && i == val1)
                count1++;
            else if (val2 != null && i == val2)
                count2++;
            else {
                if (count1 == 0) {
                    val1 = i;
                    count1 = 1;
                } else if (count2 == 0) {
                    val2 = i;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (count1 > 0) {
            count1 = 0;
            for (int i : nums)
                if (i == val1)
                    count1++;
            if (count1 > n / 3)
                list.add(val1);
        }
        if (count2 > 0) {
            count2 = 0;
            for (int i : nums)
                if (i == val2)
                    count2++;
            if (count2 > n / 3)
                list.add(val2);
        }
        return list;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}