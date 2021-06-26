
/*
1. Given a string s.
2. Return true if the s can be palindrome after deleting at most one character from it.
*/
import java.util.*;

public class validPalindrome2 {

    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
    public static boolean validPalindrome(String str) {
        // write your code here
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return isPalindrome(str.substring(i, j)) || isPalindrome(str.substring(i + 1, j + 1));
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        boolean res = validPalindrome(str);
        System.out.println(res);
    }
}