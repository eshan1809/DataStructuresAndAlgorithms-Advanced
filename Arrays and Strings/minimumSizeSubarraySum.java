/*
Given an array(list) of Integers & a Target.
Task is to "Find the MINIMUM LENGTH OF SUBARRAY whose sum is equal or greater to Target".

Example 1 : 
    Nums : [1,4,2,2,1,4]
    Target : 5
    Output : 2
    Explanation : 5 can be achieved by adding elements of minimum SubArray (1 & 4).    

Example 2 : 
    Nums : [10,5,11,24,32]
    Target : 1000
    Output : 0
    Explanation : Since no such SubArray exists whose sum is equal or greater than 1000.

Example 3 :
    Nums : [1,2,5,3,4,1,6,8]
    Target : 7
    Output : 1
    Explanation : SubArray having single element i.e. 8  has more value than target , thus output is 1.

Example 4 : 
    Nums : [1,2,5,3,4,1,6]
    Target : 7
    Output : 2
*/

import java.util.Scanner;

public class minimumSizeSubarraySum {

    public static int solution(int nums[], int target) {
        // write your code here
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0, count = 1;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minCount = Math.min(count, minCount);
                    break;
                } else
                    count++;
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        scn.close();
        System.out.println(solution(nums, target));
    }
}
