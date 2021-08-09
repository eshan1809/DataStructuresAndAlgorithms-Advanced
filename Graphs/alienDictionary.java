/*
You are given a list of strings from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.
Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
*/

import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class alienDictionary {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = br.readLine().split(" ");

        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words)
            for (char ch : word.toCharArray())
                indegree.put(ch, 0);

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i], next = words[i + 1];
            int len = Math.min(curr.length(), next.length());
            for (int j = 0; j < len; j++) {
                char ch1 = curr.charAt(j), ch2 = next.charAt(j);
                if (ch1 != ch2) {
                    Set<Character> set = map.getOrDefault(ch1, new HashSet<>());
                    if (!set.contains(ch2)) {
                        set.add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                        map.put(ch1, set);
                    }
                    break;
                }
                if (j == len - 1 && curr.length() > next.length())
                    return "";
            }
        }

        Queue<Character> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : indegree.keySet())
            if (indegree.get(ch) == 0)
                q.add(ch);

        int count = 0;
        while (!q.isEmpty()) {
            char rem = q.remove();
            sb.append(rem);
            count++;
            if (map.containsKey(rem)) {
                for (char ch : map.get(rem)) {
                    indegree.put(ch, indegree.get(ch) - 1);
                    if (indegree.get(ch) == 0)
                        q.add(ch);
                }
            }
        }

        if (count == indegree.size())
            return sb.toString();
        return "";
    }
}
