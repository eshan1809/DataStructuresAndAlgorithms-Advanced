/*
Given a list of non-negative integers nums, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.
*/

import java.util.*;

public class largestNumber {
    static class customComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return (b + a).compareTo(a + b);
        }
    }

    public static String solution(int[] nums) {
        // write your code here
        int n = nums.length;
        String[] str = new String[n];
        for (int i = 0; i < n; i++)
            str[i] = nums[i] + "";
        Arrays.sort(str, new customComparator());
        if (str[0].equals("0"))
            return "0";
        String ans = "";
        for (String s : str)
            ans += s;
        return ans;
    }

    public static void main(String[] args) {
        // input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }
        scn.close();
        System.out.println(solution(nums));
    }
}