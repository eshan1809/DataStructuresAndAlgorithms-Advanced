/*
1. Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 2. You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
 3. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 4. Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 5. For the last line of text, it should be left justified and no extra space is inserted between words.
 */

import java.util.*;

public class justificationOfText {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        // Write your code here
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            List<String> al = new ArrayList<>();
            int len = 0;
            while (i < words.length && len + words[i].length() <= maxWidth) {
                al.add(words[i]);
                len += words[i].length() + 1;
                i++;
            }
            len--;
            int remLen = maxWidth - len;
            if (i == words.length) {
                StringBuilder sb = new StringBuilder(al.get(0));
                int j = 1;
                while (j < al.size()) {
                    sb.append(" ");
                    sb.append(al.get(j++));
                }
                while (remLen-- > 0)
                    sb.append(" ");
                list.add(sb.toString());
                break;
            } else if (al.size() == 1) {
                StringBuilder sb = new StringBuilder(al.get(0));
                while (remLen-- > 0)
                    sb.append(" ");
                list.add(sb.toString());
            } else {
                int div = remLen / (al.size() - 1), rem = remLen % (al.size() - 1);
                StringBuilder sb = new StringBuilder(al.get(0));
                int j = 1;
                while (j < al.size()) {
                    sb.append(" ");
                    for (int k = 0; k < div; k++)
                        sb.append(" ");
                    if (rem-- > 0)
                        sb.append(" ");
                    sb.append(al.get(j++));
                }
                list.add(sb.toString());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        int width = sc.nextInt();
        sc.close();
        System.out.println(fullJustify(words, width));
    }
}