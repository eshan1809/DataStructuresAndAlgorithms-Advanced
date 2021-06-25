/*
1. Given an array of size 'N' and an element K.
2. Task is to find all elements that appears more than N/K times in array.
3. Return these elements in an ArrayList in sorted order.
*/

import java.util.*;

public class majorityElementGeneral {
    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        // write yout code here
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i : map.keySet())
            if (map.get(i) > n / k)
                list.add(i);
        return list;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();
        ArrayList<Integer> res = majorityElement(arr, k);
        System.out.println(res);
    }
}
