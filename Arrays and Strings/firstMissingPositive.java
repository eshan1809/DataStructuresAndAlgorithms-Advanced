/*
1. Given an unsorted integer array 'arr'.
2. Find the smallest missing positive integer.
Note : You must implement an algorithm that runs in O(n) time and uses constant extra space.
*/

import java.util.*;

public class firstMissingPositive {
    public static int solution(int[] arr) {
        // write your code here
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (arr[i] != i + 1 && arr[i] < n && arr[i] > 0) {
                int temp = arr[i];
                if (temp == arr[temp - 1])
                    break;
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }
        for (int i = 0; i < n; i++)
            if (arr[i] != i + 1)
                return i + 1;
        return n + 1;
    }

    // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        int res = solution(arr);
        System.out.println(res);
    }
}
