/*
1. Given an m x n board of characters and a list of strings words, return all words present on the board.
2. Word must be made from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

You can return word's in any order.
*/

import java.io.*;
import java.util.*;

public class wordSearch2 {
    static class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[26];
        }
    }

    static Node root;

    private static void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Node();
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    private static void search(Node curr, char[][] board, int r, int c, String ans, ArrayList<String> list,
            boolean[][] visited) {
        if (curr.isEnd) {
            list.add(ans);
            curr.isEnd = false;
        }

        if (r < 0 || c < 0 || r == board.length || c == board[0].length || visited[r][c])
            return;

        char ch = board[r][c];
        visited[r][c] = true;
        if (curr.children[ch - 'a'] != null) {
            search(curr.children[ch - 'a'], board, r - 1, c, ans + ch, list, visited);
            search(curr.children[ch - 'a'], board, r, c - 1, ans + ch, list, visited);
            search(curr.children[ch - 'a'], board, r + 1, c, ans + ch, list, visited);
            search(curr.children[ch - 'a'], board, r, c + 1, ans + ch, list, visited);
        }
        visited[r][c] = false;
    }

    public static ArrayList<String> findWords(char[][] board, String[] words) {
        root = new Node();

        for (String word : words)
            insert(word);

        int n = board.length, m = board[0].length;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                search(root, board, i, j, "", list, new boolean[n][m]);

        return list;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int m = Integer.parseInt(read.readLine());
        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = read.readLine().trim().toCharArray();
        }
        int count = Integer.parseInt(read.readLine());
        String words[] = new String[count];
        for (int i = 0; i < count; i++) {
            words[i] = read.readLine();
        }

        ArrayList<String> result = findWords(board, words);
        Collections.sort(result);
        System.out.println(result);

    }
}
