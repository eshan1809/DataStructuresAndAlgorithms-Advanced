/*
Given two sentences sentence1 and sentence2 each represented as a string array and given a 2d array of string pairs where each row contains two words {x,y} indicating that the word x and y are similar.
Return true if sentence1 and sentence2 are similar, or false if they are not similar. Two sentences are similar if they have the same length and sentence1[i] and sentences2[i] are similar.

Note: Similarity relation is transitive.
*/

import java.io.*;
import java.util.*;

public class sentenceSimilarity {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] sentence1 = br.readLine().split(" ");
        String[] sentence2 = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());

        String[][] pairs = new String[m][2];
        for (int i = 0; i < m; i++) {
            pairs[i] = br.readLine().split(" ");
        }

        System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));

    }

    public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
        int n = Sentence1.length;
        if (Sentence2.length != n)
            return false;
        parent = new HashMap<>();
        rank = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            if (!rank.containsKey(pairs[i][0])) {
                rank.put(pairs[i][0], 0);
                parent.put(pairs[i][0], pairs[i][0]);
            }
            if (!rank.containsKey(pairs[i][1])) {
                rank.put(pairs[i][1], 0);
                parent.put(pairs[i][1], pairs[i][1]);
            }
            union(pairs[i][0], pairs[i][1]);
        }
        for (int i = 0; i < n; i++)
            if (find(Sentence1[i]) != find(Sentence2[i]))
                return false;
        return true;
    }

    static Map<String, String> parent;
    static Map<String, Integer> rank;

    private static String find(String str) {
        if (parent.get(str) == str)
            return str;
        String l = find(parent.get(str));
        parent.put(str, l);
        return l;
    }

    private static void union(String str1, String str2) {
        String l1 = find(str1), l2 = find(str2);
        if (rank.get(l1) > rank.get(l2))
            parent.put(l2, l1);
        else if (rank.get(l1) < rank.get(l2))
            parent.put(l1, l2);
        else {
            parent.put(l1, l2);
            rank.put(l2, rank.get(l2) + 1);
        }
    }
}
