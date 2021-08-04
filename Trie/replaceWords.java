/*
1. You r given an array of string's say dictionary and a long string say sentence.
2. You have to replace all words in sentence which contains a prefix in dictionary with the prefix itself in dictionary.

Example 
dictionary = ["cat","bat","rat"]
sentence = "the cattle was rattled by the battery"

In this sentence cattle, rattled and battery are the words containing prefix in dictionary they are cat, rat and bat.
sentence after replace words is "the cat was rat by the bat".

3. If there are multiple prefix for a word in dictionary replace it with the shortest prefix word.
*/

import java.io.*;

public class replaceWords {
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

    public static String getWord(String word) {
        StringBuilder sb = new StringBuilder();
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                return word;
            curr = curr.children[ch - 'a'];
            sb.append(ch);
            if (curr.isEnd)
                break;
        }
        return sb.toString();
    }

    public static String replacewords(String[] dictionary, String sentence) {
        root = new Node();
        insert(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words)
            sb.append(getWord(word) + " ");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        String[] dictionary = new String[n];

        for (int i = 0; i < n; i++) {
            dictionary[i] = read.readLine();
        }

        String sentence = read.readLine();

        String result = replacewords(dictionary, sentence);
        System.out.println(result);

    }
}
