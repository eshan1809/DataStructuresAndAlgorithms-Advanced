/*
1. Given an integer array 'arr'.
2. Reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
3. You may assume the input array always has a valid answer.
Note : You can return answer in any order.
*/

import java.util.*;

public class wiggleSort2 {

    // ~~~~~~~~~~~~~User's Section~~~~~~~~~~~~
    public static void wiggleSort(int[] nums) {
        // write your code here
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int n = nums.length, idx = 0;
        for (int i = 0; i < n; i += 2)
            nums[i] = clone[idx++];
        for (int i = 1; i < n; i += 2)
            nums[i] = clone[idx++];
    }

    // ~~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        wiggleSort(arr);
        /*
         * -if index is even then smaller than next, -if index is odd then greater than
         * next element, -to check any correct order, we will not print array, we will
         * check inequality -if print false, that means wrong answer, if true than
         * correct answer.
         */
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && arr[i] >= arr[i + 1]) {
                System.out.println(false);
                return;
            } else if (i % 2 == 1 && arr[i] <= arr[i + 1]) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}