/*
1. A string 's' of lowercase English letters is given. 
2. We want to partition this string into as many parts as possible so that each letter appears in at most one part.
3. Return a list of integers representing the size of these parts.
*/

import java.util.*;

public class partitionLabels {
    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static List<Integer> solve(String s) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> lastOcc = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            lastOcc.put(s.charAt(i), i);
        Integer j = null, prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j == null)
                j = lastOcc.get(s.charAt(i));
            if (i == j) {
                list.add(i + 1 - prev);
                prev = i + 1;
                j = null;
            } else {
                j = Math.max(j, lastOcc.get(s.charAt(i)));
            }
        }
        return list;
    }

    // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        List<Integer> res = solve(str);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
