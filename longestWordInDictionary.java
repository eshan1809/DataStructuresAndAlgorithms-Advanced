/*
1. Given an array of strings words.
2. Find the word of longest length, where all of its substrings starting from 0th index exists as different word in array.
3. If there are multiple answers with same length return one which is smallest in lexicographical order. If there is no valid string return empty string.
*/

import java.io.*;

public class longestWordInDictionary {
    static class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[26];
            isEnd = false;
        }
    }

    static Node root;

    public static void insert(String[] words) {
        for (String word : words) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null)
                    curr.children[ch - 'a'] = new Node();
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
        }
    }

    public static String getAns(String[] words) {
        String ans = "";
        for (String word : words) {
            Node curr = root;
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null)
                    break;
                curr = curr.children[ch - 'a'];
                sb.append(ch);
                if (!curr.isEnd)
                    break;
                if (sb.length() > ans.length())
                    ans = sb.toString();
                else if (sb.length() == ans.length()) {
                    String pAns = sb.toString();
                    if (ans.compareTo(pAns) > 0)
                        ans = pAns;
                }
            }
        }
        return ans;
    }

    public static String longestWord(String[] words) {
        root = new Node();
        insert(words);
        return getAns(words);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = read.readLine();
        }

        String result = longestWord(words);
        System.out.println(result);

    }
}
