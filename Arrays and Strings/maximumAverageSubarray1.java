/*
Given a list of Integers(array) & a number K.
Task is to "Find MAXIMUM AVERAGE of Contiguous subarray of size k."

Example 1 : 
    Nums : [-10,5,-6,8,-7,2,-4,8,-6,7] , K : 3
    Output : 3.0
    Explanation : average of 8,-6,7 is maximum

Example 2 : 
    Nums : [1,2,-3,-4,5,-6] , K = 2
    Output : 1.5
*/

import java.util.Scanner;

public class maximumAverageSubarray1 {
    public static double solution(int nums[], int k) {
        // write your code here
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        int ans = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            ans = Math.max(ans, sum);
        }
        return (double) ans / k;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();
        System.out.println(solution(nums, k));
    }
}