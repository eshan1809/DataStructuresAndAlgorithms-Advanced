/*
1. You are given N number of words.
2. You are given M puzzles in the form of M strings.
3. For a given puzzle, a word is valid if both the following conditions are confirmed - 
    Condition 1 -> Word contains the first letter of puzzle.
    Condition 2 -> For each letter in word, that letter should be present in puzzle.
4. You have to print the number of valid words corresponding to a puzzle.
*/

import java.util.*;

public class numberOfValidWords {

    public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        // write your code here
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 26; i++)
            map.put((char) ('a' + i), new ArrayList<>());
        for (String word : words) {
            int mask = 0;
            for (char ch : word.toCharArray()) {
                int bit = ch - 'a';
                mask = mask | (1 << bit);
            }
            Set<Character> unique = new HashSet<>();
            for (char ch : word.toCharArray()) {
                if (unique.contains(ch))
                    continue;
                map.get(ch).add(mask);
                unique.add(ch);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (String puzzle : puzzles) {
            int pmask = 0;
            for (char ch : puzzle.toCharArray()) {
                int bit = ch - 'a';
                pmask = pmask | (1 << bit);
            }
            List<Integer> wordsToCheck = map.get(puzzle.charAt(0));
            int count = 0;
            for (int wmask : wordsToCheck) {
                if ((wmask & pmask) == wmask)
                    count++;
            }
            list.add(count);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for (int i = 0; i < m; i++) {
            puzzles[i] = scn.next();
        }
        scn.close();
        ArrayList<Integer> ans = findNumOfValidWords(words, puzzles);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
    }

}