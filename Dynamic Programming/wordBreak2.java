/*
1. You are given n space-separated strings, which represents a dictionary of words.
2. You are given another string that represents a sentence.
3. You have to determine if this sentence can be segmented into a space-separated sequence of one or more dictionary words.
*/

import java.util.*;

public class wordBreak2 {

    public static boolean solution(String str, HashSet<String> dict) {
        // write your code here
        if (str.length() == 0)
            return true;

        for (int i = 0; i < str.length(); i++)
            if (dict.contains(str.substring(0, i + 1)) && solution(str.substring(i + 1), dict))
                return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashSet<String> dictionary = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            dictionary.add(scn.next());
        }
        String sentence = scn.next();
        scn.close();
        System.out.println(solution(sentence, dictionary));
    }

}