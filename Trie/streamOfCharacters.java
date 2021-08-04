/*
Implement the StreamChecker class as follows:

1. StreamChecker(words): Constructor, init the data structure with the given words.
2. query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
*/

import java.io.*;

public class streamOfCharacters {
    public static class StreamChecker {
        class Node {
            Node[] children;
            boolean isEnd;

            Node() {
                children = new Node[26];
                isEnd = false;
            }
        }

        Node root;
        StringBuilder sb;

        public StreamChecker(String[] words) {
            root = new Node();
            sb = new StringBuilder();
            for (String word : words) {
                Node curr = root;
                for (int i = word.length() - 1; i >= 0; i--) {
                    int idx = word.charAt(i) - 'a';
                    if (curr.children[idx] == null)
                        curr.children[idx] = new Node();
                    curr = curr.children[idx];
                }
                curr.isEnd = true;
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            Node curr = root;
            for (int i = sb.length() - 1; i >= 0; i--) {
                int idx = sb.charAt(i) - 'a';
                if (curr.children[idx] == null)
                    break;
                curr = curr.children[idx];
                if (curr.isEnd)
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = read.readLine();
        }

        StreamChecker obj = new StreamChecker(words);

        n = Integer.parseInt(read.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(obj.query(read.readLine().charAt(0)));
        }
    }
}
