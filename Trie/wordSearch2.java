/*
1. Given an m x n board of characters and a list of strings words, return all words present on the board.
2. Word must be made from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

You can return word's in any order.
*/

import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class wordSearch2 {
    public static boolean boardContains(char[][] board, String word, int r, int c, int idx, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        if (r - 1 >= 0 && board[r - 1][c] == word.charAt(idx) && visited[r - 1][c] == false) {
            visited[r - 1][c] = true;
            if (boardContains(board, word, r - 1, c, idx + 1, visited))
                return true;
            visited[r - 1][c] = false;
        }
        if (c - 1 >= 0 && board[r][c - 1] == word.charAt(idx) && visited[r][c - 1] == false) {
            visited[r][c - 1] = true;
            if (boardContains(board, word, r, c - 1, idx + 1, visited))
                return true;
            visited[r][c - 1] = false;
        }
        if (r + 1 < board.length && board[r + 1][c] == word.charAt(idx) && visited[r + 1][c] == false) {
            visited[r + 1][c] = true;
            if (boardContains(board, word, r + 1, c, idx + 1, visited))
                return true;
            visited[r + 1][c] = false;
        }
        if (c + 1 < board[0].length && board[r][c + 1] == word.charAt(idx) && visited[r][c + 1] == false) {
            visited[r][c + 1] = true;
            if (boardContains(board, word, r, c + 1, idx + 1, visited))
                return true;
            visited[r][c + 1] = false;
        }
        return false;
    }

    public static ArrayList<String> findWords(char[][] board, String[] words) {
        ArrayList<String> list = new ArrayList<>();
        int n = board.length, m = board[0].length;
        for (String word : words) {
            boolean[][] visited = new boolean[n][m];
            int flag = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        visited[i][j] = true;
                        if (boardContains(board, word, i, j, 1, visited))
                            flag = 1;
                        visited[i][j] = false;
                    }
                    if (flag == 1)
                        break;
                }
                if (flag == 1)
                    break;
            }
            if (flag == 1)
                list.add(word);
        }
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
