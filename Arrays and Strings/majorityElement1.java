/*
1. Give an array of size 'n'.
2. Find Majority element and print it(if exist), otherwise print "No Majority Element exist".
3. Majority element-> if frequency of an element is more than n/2, then that element is majority element.
3. Note : solve the problem in linear time and in O(1) space.
*/

import java.util.*;

public class majorityElement1 {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static void printMajorityElement(int[] arr) {
        // write your code here
        int count = 1, prev = arr[0], n = arr.length;
        for (int i = 1; i < n; i++) {
            if (count == 0)
                prev = arr[0];
            if (arr[i] == prev)
                count++;
            else
                count--;
        }
        if (count > 0) {
            count = 0;
            for (int i : arr)
                if (i == prev)
                    count++;
            if (count >= n / 2) {
                System.out.println(prev);
                return;
            }
        }
        System.out.println("No Majority Element exist");
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        printMajorityElement(arr);
    }
}