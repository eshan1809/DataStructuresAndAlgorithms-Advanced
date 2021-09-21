/*
1. You are given an integer array A of size N.
2. You have to find and return sequence of pancake flips that sort A. Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
3. In a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.
4. For example,
Input: arr[] = {3,2,4,1}

Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. 

Note:
1. main takes input from the users.
2. display is a utility function that displays an array. Feel free to use it for debugging purposes.
3. This is a functional problem.
4. You have to complete the function pancakeSort. It takes as input an integer array. It should return an arraylist of integers representing the sequence.
*/

import java.util.*;

public class pancakeSorting {

    // This is a functional problem. You have to complete this function.
    // It takes as input an integer array. It should return an arraylist
    // of integers representing the sequence.
    public static void flip(int[] arr, int idx) {
        int i = 0;
        while (i < idx) {
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
            idx--;
            i++;
        }
    }

    public static ArrayList<Integer> pancakeSort(int[] arr) {
        // write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        while (n > 1) {
            int idx = 0;
            for (int i = 1; i < n; i++)
                if (arr[i] > arr[idx])
                    idx = i;

            if (idx < n - 1) {
                list.add(idx + 1);
                flip(arr, idx);
                list.add(n);
                flip(arr, n - 1);
            }
            n--;
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // taking input for given array
        int N = scn.nextInt();
        int[] arr = new int[N];
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            l.add(arr[i]);
        }
        scn.close();
        ArrayList<Integer> res = pancakeSort(arr);
        makeFlips(res, l);

    }

    public static void makeFlips(ArrayList<Integer> list, List<Integer> l) {
        for (Integer i : list) {
            Collections.reverse(l.subList(0, i));
        }

        for (Integer i : l) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // utility function to display an array.
    public static void display(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

}