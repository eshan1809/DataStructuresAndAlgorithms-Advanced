/*
1. You are given a 10*10 2-D array(arr) containing only '+' and '-' characters, which represents a 
    crossword puzzle. 
2. You are also given n number of words which need to be filled into the crossword.
3. Cells containing '-' are to be filled with the given words.
*/

import java.util.*;

public class crosswordPuzzle {

    public static void solution(char[][] arr, String[] words, int vidx) {
        // write your code here
        if (vidx == words.length) {
            print(arr);
            return;
        }
        String word = words[vidx];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    if (canPlaceHorizontally(arr, word, i, j)) {
                        boolean[] placed = PlaceHorizontally(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unPlaceHorizontally(arr, placed, i, j);
                    }
                    if (canPlaceVertically(arr, word, i, j)) {
                        boolean[] placed = PlaceVertically(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unPlaceVertically(arr, placed, i, j);
                    }
                }
            }
        }
    }

    static boolean canPlaceHorizontally(char[][] arr, String word, int i, int j) {
        if (j > 0 && arr[i][j - 1] != '+') {
            return false;
        }
        if (j + word.length() < 10 && arr[i][j + word.length()] != '+') {
            return false;
        }
        for (int jj = 0; jj < word.length(); jj++) {
            if (j + jj >= arr.length) {
                return false;
            }
            if (arr[i][j + jj] != '-' && arr[i][j + jj] != word.charAt(jj)) {
                return false;
            }
        }
        return true;
    }

    static boolean canPlaceVertically(char[][] arr, String word, int i, int j) {
        if (i > 0 && arr[i - 1][j] != '+') {
            return false;
        }
        if (i + word.length() < 10 && arr[i + word.length()][j] != '+') {
            return false;
        }
        for (int ii = 0; ii < word.length(); ii++) {
            if (i + ii >= arr.length) {
                return false;
            }
            if (arr[i + ii][j] != '-' && arr[i + ii][j] != word.charAt(ii)) {
                return false;
            }
        }
        return true;
    }

    static boolean[] PlaceHorizontally(char[][] arr, String word, int i, int j) {
        boolean[] placed = new boolean[word.length()];
        for (int jj = 0; jj < word.length(); jj++) {
            if (arr[i][j + jj] == '-') {
                placed[jj] = true;
                arr[i][j + jj] = word.charAt(jj);
            }
        }
        return placed;
    }

    static boolean[] PlaceVertically(char[][] arr, String word, int i, int j) {
        boolean[] placed = new boolean[word.length()];
        for (int ii = 0; ii < word.length(); ii++) {
            if (arr[i + ii][j] == '-') {
                placed[ii] = true;
                arr[i + ii][j] = word.charAt(ii);
            }
        }
        return placed;
    }

    static void unPlaceHorizontally(char[][] arr, boolean[] placed, int i, int j) {
        for (int jj = 0; jj < placed.length; jj++) {
            if (placed[jj] == true) {
                arr[i][j + jj] = '-';
            }
        }
    }

    static void unPlaceVertically(char[][] arr, boolean[] placed, int i, int j) {
        for (int ii = 0; ii < placed.length; ii++) {
            if (placed[ii] == true) {
                arr[i + ii][j] = '-';
            }
        }
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
        scn.close();
    }
}