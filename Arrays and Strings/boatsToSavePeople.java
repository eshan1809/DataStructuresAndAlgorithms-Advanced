/*
1. You are given an array people where people[i] is the weight of the ith person.
2. You have infinite number of boats where each boat can carry a maximum weight of limit. 
3. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
4. Return the minimum number of boats to carry every given person.
*/

import java.util.*;

public class boatsToSavePeople {

    // ~~~~~~~~~~~User's Section~~~~~~~~~~~~
    public static int numRescueBoats(int[] people, int limit) {
        // write your code here
        Arrays.sort(people);
        int i = 0, j = people.length - 1, ans = 0;
        while (i < j) {
            if (people[j] + people[i] <= limit)
                i++;
            j--;
            ans++;
        }
        if (i == j)
            ans++;
        return ans;
    }

    // ~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] people = new int[n];

        for (int i = 0; i < n; i++)
            people[i] = scn.nextInt();

        int limit = scn.nextInt();
        scn.close();
        int boats = numRescueBoats(people, limit);
        System.out.println(boats);
    }
}