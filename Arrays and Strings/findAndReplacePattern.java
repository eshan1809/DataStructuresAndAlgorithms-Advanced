/*
1. Given a list of strings words and a string pattern.
2. Return a list of words[i] that match pattern. You may return the answer in any order.
3. A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
4. Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.
*/

import java.util.*;

public class findAndReplacePattern {

    // ~~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~
    public static List<String> solve(String[] words, String pattern) {
        // write your code here
        List<String> list = new ArrayList<>();
        for (String word : words) {
            Map<Character, Character> map = new HashMap<>();
            int flag = 0;
            boolean[] used = new boolean[26];
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i), p = pattern.charAt(i);
                if (map.containsKey(p)) {
                    if (map.get(p) != ch) {
                        flag = 1;
                        break;
                    }
                } else {
                    if (used[ch - 'a'] == false) {
                        map.put(p, ch);
                        used[ch - 'a'] = true;
                    } else {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0)
                list.add(word);
        }
        return list;
    }

    // ~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String pattern = scn.nextLine();
        int n = scn.nextInt();
        scn.nextLine(); // to consume enter after number
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scn.nextLine();
        }
        scn.close();
        List<String> res = solve(words, pattern);
        if (res.size() == 0) {
            System.out.println("Empty");
            return;
        }
        Collections.sort(res);
        for (String str : res) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}