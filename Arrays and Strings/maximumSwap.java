/*
1. You are given a number in form of String. 
2. You can swap two digits at most once to get the maximum valued number in that string.
3. Return the maximum valued number you can get in form of string.
*/

import java.util.*;

public class maximumSwap {

    // ~~~~~~~~~~User Section~~~~~~~~~~~
    public static String solution(String num) {
        // write your code here
        char[] ch = num.toCharArray();
        int n = ch.length;
        int[] last = new int[10];
        for (int i = 0; i < n; i++)
            last[ch[i] - '0'] = i;
        for (int i = 0; i < n; i++) {
            for (int j = 9; j > ch[i] - '0'; j--) {
                if (i < last[j]) {
                    char temp = ch[i];
                    ch[i] = ch[last[j]];
                    ch[last[j]] = temp;
                    return new String(ch);
                }
            }
        }
        return num;
    }

    // ~~~~~~~~Input Management~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        String ans = solution(str);
        System.out.println(ans);
    }
}