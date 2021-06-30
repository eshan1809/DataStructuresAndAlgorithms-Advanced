/*
1. Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
2. Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
3. It is guaranteed that there will be an answer.
*/

import java.util.*;

public class findTheSmallestDivisorGivenAThreshold {
    public static int check(int[] nums, int d) {
        int ans = 0;
        for (int i : nums)
            ans += (int) Math.ceil((double) i / d);
        return ans;
    }

    public static int findSmallestDivisor(int[] nums, int th) {
        // write your code here
        int ans = Integer.MAX_VALUE, lo = 1, hi = 0;
        for (int i = 0; i < nums.length; i++)
            hi = Math.max(hi, nums[i]);
        hi++;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(nums, mid) <= th) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // input work
        int n = scn.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }

        int th = scn.nextInt();
        scn.close();
        int speed = findSmallestDivisor(nums, th);
        System.out.println(speed);
    }
}