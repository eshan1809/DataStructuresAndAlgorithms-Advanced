/*
1. We have arrival and departure times of all trains that reach a railway station. 
2. We have to find the minimum number of platforms required for the railway station so that no train is kept waiting.
3. Consider that all the trains arrive on the same day and leave on the same day. 
4. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. 
5. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.
*/

import java.util.*;

public class minimumNumberOfPlatform {

    public static int findPlatform(int[] arr, int[] dep) {
        // write your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, plat = 0, ans = 0;
        while (i < arr.length) {
            if (arr[i] <= dep[j]) {
                plat++;
                i++;
            } else {
                plat--;
                j++;
            }
            ans = Math.max(ans, plat);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] dep = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dep[i] = scn.nextInt();
        }
        scn.close();
        int plateforms = findPlatform(arr, dep);
        System.out.println(plateforms);
    }
}