/*
1. Given an array nums of non-negative integers.
2. Arrange elements of array in specific order, all even elements followed by odd elements. [even -> odd]
3. Preserve the order of Even elements without using extra space.
4. Hence question is order specific so you have to match your output in order of given output.
*/

import java.util.*;

public class sortArrayByParity {

    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~

    public static void sortByParity(int[] nums) {
        // write your code here
        int i = 0;
        while (i < nums.length && nums[i] % 2 == 0)
            i++;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    //// ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        sortByParity(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}