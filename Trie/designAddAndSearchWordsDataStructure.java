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

        public WordDictionary() {
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot
         * character '.' to represent any one letter.
         */
        public boolean search(String word) {
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
