/*
Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
*/

import java.util.*;

public class largestPerimeterTriangle {
    public static int largestPerimeter(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--)
            if (nums[i] < nums[i - 1] + nums[i - 2])
                return nums[i] + nums[i - 1] + nums[i - 2];
        return 0;
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
        System.out.println(largestPerimeter(nums));
    }
}