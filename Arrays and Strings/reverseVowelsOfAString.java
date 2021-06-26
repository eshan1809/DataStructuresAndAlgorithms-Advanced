/*
1. Given a string 's'.
2. Reverse only all the vowels in the string and return it.
3. The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
*/

import java.util.*;

public class Main {
    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U';
    }

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (isVowel(arr[i]) && isVowel(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            if (!isVowel(arr[i]))
                i++;
            if (!isVowel(arr[j]))
                j--;
        }
        return String.valueOf(arr);
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        String res = reverseVowels(str);
        System.out.println(res);
    }
}
