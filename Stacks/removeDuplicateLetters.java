/*
1. Given a string s, remove duplicate letters so that every letter appears once and only once.
2. You must make sure your result is the first in dictionary order among all possible results.
*/

import java.io.*;
import java.util.*;

public class removeDuplicateLetters {
    public static String removeDuplicates(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        Stack<Character> st = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if (set.contains(ch))
                continue;
            while (st.size() > 0 && st.peek() > ch && freq[st.peek() - 'a'] > 0)
                set.remove(st.pop());
            st.push(ch);
            set.add(ch);
        }
        String str = "";
        while (st.size() > 0)
            str = st.pop() + str;
        return str;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = removeDuplicates(read.readLine());
        System.out.println(result);

    }
}
