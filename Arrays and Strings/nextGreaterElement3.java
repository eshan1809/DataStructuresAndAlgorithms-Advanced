/*
1. Given a positive number 'n' in form of String.
2. Find the smallest number which has exactly the same digits existing in the number 'n' and is greater in value than 'n'.
3. If no such positive number exists, return -1 as string.
*/

import java.util.*;

public class nextGreaterElement3 {
    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static String nextGreaterElement(String str) {
        // write your code here
        int n = str.length(), i = n - 2, k = n - 1;
        char[] arr = str.toCharArray();
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;
        if (i == -1)
            return "-1";
        while (arr[i] >= arr[k])
            k--;
        char temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;

        String ans = "";
        for (int j = 0; j <= i; j++)
            ans += arr[j];
        for (int j = n - 1; j > i; j--)
            ans += arr[j];
        return ans;
    }

    // ~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.next();
        String res = nextGreaterElement(num);
        scn.close();
        System.out.println(res);
    }
}
