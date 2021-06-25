/*
1. Given an integer array of size 'n'.
2. Return an array answer such that answer[i] is equal to the product of all the elements of arr except arr[i].
3. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    Note -> You should not use division operator
*/

import java.util.*;

public class productOfArrayExceptSelf {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static int[] productExceptSelf(int[] nums) {
        // write your code here
        int n = nums.length, lm = 1, rm = 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = lm;
            lm *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rm;
            rm *= nums[i];
        }
        return ans;
    }

    // ~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        int[] res = productExceptSelf(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}