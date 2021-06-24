/*
1. Given an integer array 'nums' sorted in non-decreasing order.
2. Return an array of the squares of each number sorted in non-decreasing order.
*/

import java.util.*;

public class squaresOfASortedArray {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] sortedSquares(int[] nums) {
        // write your code here
        int[] sqa = new int[nums.length];
        int i = 0, j = nums.length - 1, k = j;
        while (i <= j) {
            int x = nums[i] * nums[i], y = nums[j] * nums[j];
            if (x > y) {
                sqa[k--] = x;
                i++;
            } else {
                sqa[k--] = y;
                j--;
            }
        }
        return sqa;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = scn.nextInt();

        scn.close();

        int[] res = sortedSquares(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}