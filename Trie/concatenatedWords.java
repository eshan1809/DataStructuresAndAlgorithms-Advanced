/*
Given an array of strings words, return all the concatenated words in the given list of words.
Concatenated word is a word that can be created by concatination of at least two other shorter words from the list.

You can return concatination words in any order
*/

import java.io.*;
import java.util.*;

public class concatenatedWords {
    static class Node {
        Node[] children;
        boolean end;

        Node() {
            end = false;
            children = new Node[26];
        }
    }

    static Node root;

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<String>();
        if (words.length <= 2)
            return list;
        root = new Node();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            if (word.isEmpty())
                continue;
            if (isPossible(word, 0))
                list.add(word);
            else
                insert(word);
        }
        return list;
    }

    private static boolean isPossible(String word, int index) {
        if (index == word.length())
            return true;
        Node curr = root;
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            curr = curr.children[ch - 'a'];
            if (curr == null)
                return false;
            if (curr.end && isPossible(word, i + 1))
                return true;
        }
        return false;
    }

    private static void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Node();
            curr = curr.children[ch - 'a'];
        }
        curr.end = true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = read.readLine();
        }

        List<String> result = findAllConcatenatedWordsInADict(words);
        Collections.sort(result);
        PrintWriter out = new PrintWriter(System.out);
        for (String s : result) {
            out.println(s);
        }
        out.close();
    }
}