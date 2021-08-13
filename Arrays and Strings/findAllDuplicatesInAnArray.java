/*
1. Given an integer array nums of length n where all the integers of nums are in the range [1, n].
2. Each integer appears once or twice, return an array of all the integers that appears twice.
3. You must write an algorithm that runs in O(n) time and uses only constant extra space.
*/

import java.util.*;

public class findAllDuplicatesInAnArray {
    // ~~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
    public static List<Integer> findDuplicates(int[] nums) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] > 0)
                nums[pos] = -nums[pos];
            else
                list.add(pos + 1);
        }
        return list;
    }

    // ~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        List<Integer> res = findDuplicates(arr);
        if (res.size() == 0) {
            System.out.println("Empty");
            return;
        }
        Collections.sort(res);
        for (int val : res)
            System.out.print(val + " ");
        System.out.println();
    }
}
