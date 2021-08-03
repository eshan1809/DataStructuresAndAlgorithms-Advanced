/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:
1. WordDictionary() Initializes the object.
2. void addWord(word) Adds word to the data structure, it can be matched later.
3. boolean search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
*/

import java.io.*;

public class designAddAndSearchWordsDataStructure {
    public static class WordDictionary {

        public class Node {
            Node[] children;
            boolean isEnd;

            Node() {
                children = new Node[26];
            }
        }

        final Node root;

        public WordDictionary() {
            root = new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null)
                    curr.children[ch - 'a'] = new Node();
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean searchHelper(Node curr, String word, int idx) {
            if (idx == word.length())
                return curr.isEnd;
            char ch = word.charAt(idx);
            if (ch == '.') {
                for (int i = 0; i < 26; i++)
                    if (curr.children[i] != null)
                        if (searchHelper(curr.children[i], word, idx + 1))
                            return true;
            } else {
                if (curr.children[ch - 'a'] == null)
                    return false;
                else
                    return searchHelper(curr.children[ch - 'a'], word, idx + 1);
            }
            return false;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot
         * character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return searchHelper(root, word, 0);
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
