/*
1. You are given an array of strings.
2. You have to group anagrams together.
Note -> Every string consists of lower-case English letters only.
*/

import java.util.*;

public class group_Anagrams {
	public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
		// write your code here
		int n = strs.length;
		int[][] arr = new int[n][26];
		for (int i = 0; i < n; i++)
			for (char ch : strs[i].toCharArray())
				arr[i][ch - 'a']++;
		boolean[] used = new boolean[n];
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (used[i])
				continue;
			ArrayList<String> al = new ArrayList<>();
			al.add(strs[i]);
			for (int j = i + 1; j < n; j++) {
				if (used[j])
					continue;
				int flag = 0;
				for (int k = 0; k < 26; k++) {
					if (arr[i][k] != arr[j][k]) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					used[j] = true;
					al.add(strs[j]);
				}
			}
			list.add(al);
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> anagramsGrouped = groupAnagrams(arr);
		for (ArrayList<String> lst : anagramsGrouped) {
			Collections.sort(lst);
		}
		anagramsGrouped.sort(new ListComparator());
		display(anagramsGrouped);
		sc.close();
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}
}
