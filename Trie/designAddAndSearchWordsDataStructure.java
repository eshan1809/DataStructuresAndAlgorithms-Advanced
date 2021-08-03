/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:
1. WordDictionary() Initializes the object.
2. void addWord(word) Adds word to the data structure, it can be matched later.
3. boolean search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
*/

import java.io.*;
import java.util.*;

public class designAddAndSearchWordsDataStructure {
    public static class WordDictionary {

        List<String> list;
        HashMap<String, Boolean> ans;
        boolean canUse;

        /** Initialize your data structure here. */
        public WordDictionary() {
            list = new ArrayList();
            ans = new HashMap();
        }

        public void addWord(String word) {
            list.add(word);
            canUse = false;
        }

        public boolean search(String word) {
            if (canUse && ans.containsKey(word))
                return ans.get(word);

            canUse = true;
            for (String str : list) {
                if (str.length() == word.length()) {
                    int flag = 0;
                    for (int i = 0; i < str.length(); i++) {
                        if (word.charAt(i) == '.')
                            continue;
                        if (word.charAt(i) != str.charAt(i)) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        ans.put(word, true);
                        return true;
                    }
                }
            }
            ans.put(word, false);
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        WordDictionary obj = new WordDictionary();

        while (read.ready()) {
            String inp[] = read.readLine().split(" ");

            if (inp[0].equals("addWord")) {
                obj.addWord(inp[1]);
            } else if (inp[0].equals("search")) {
                System.out.println(obj.search(inp[1]));
            }
        }

    }
}
