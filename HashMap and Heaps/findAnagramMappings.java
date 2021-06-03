/*
1. You are given two integer arrays(A and B), where B is an anagram of A.
2. B is an anagram of A means B is made by randomizing the order of the elements in A.
3. For every element in A, you have to print the index of that element in B.

Note -> Both arrays(A and B) are of the same length.
*/

import java.util.*;

public class findAnagramMappings {
    public static int[] anagramMappings(int[] arr1, int[] arr2) {
        // write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                map.get(arr2[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr2[i], list);
            }
        }
        int[] arr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            List<Integer> list = map.get(arr1[i]);
            arr[i] = list.remove(0);
            if (list.size() == 0)
                map.remove(arr1[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        for (int j = 0; j < b.length; j++) {
            b[j] = s.nextInt();
        }
        int[] res = anagramMappings(a, b);
        for (int j = 0; j < res.length; j++) {
            System.out.print(res[j] + " ");
        }
        s.close();
    }
}
