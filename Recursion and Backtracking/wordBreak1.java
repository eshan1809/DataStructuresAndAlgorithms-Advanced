/*
1. You are given n space separated strings, which represents a dictionary of words.
2. You are given another string which represents a sentence.
3. You have to print all possible sentences from the string, such that words of the sentence are present in dictionary.
*/

import java.util.*;

public class wordBreak1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for (int i = 0; i < n; i++) {
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence, "", dict);
		scn.close();
	}

	public static void wordBreak(String str, String ans, HashSet<String> dict) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String ss = str.substring(0, i + 1);
			if (dict.contains(ss)) {
				String rs = str.substring(i + 1);
				wordBreak(rs, ans + ss + " ", dict);
			}
		}
	}
}