/*
1. Given an Array of size 'n' have may or may not be repeated elements.
2. A 'target' is provided.
3. Return Pair of target sum in which all pairs are unique, for example : [1, 2], [2, 1] are consider as same pair.
4. If array have repeated element then return only unique pair, for example : if array is arr = [2, 2, 4, 4], and target = 6 then res have only one pair, i.e. [2, 4]
*/

import java.util.*;

public class TwoSumTargetSumUniquePairs {

    // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
    public static List<List<Integer>> twoSum(int[] arr, int target) {
        // write your code here
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == target) {
                List<Integer> al = new ArrayList<>();
                al.add(arr[i]);
                al.add(arr[j]);
                list.add(al);
                j--;
                while (j > i && arr[j] == arr[j + 1])
                    j--;
                i++;
                while (i < j && arr[i] == arr[i - 1])
                    i++;
            } else if (arr[i] + arr[j] > target) {
                j--;
                while (j > i && arr[j] == arr[j + 1])
                    j--;
            } else {
                i++;
                while (i < j && arr[i] == arr[i - 1])
                    i++;
            }
        }
        return list;
    }

    // ~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        scn.close();
        List<List<Integer>> res = twoSum(arr, target);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            Collections.sort(list);
            String ans = "";
            for (int val : list) {
                ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }
}