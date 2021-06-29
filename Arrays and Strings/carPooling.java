/*
1. A car moving in east direction has to make some pickups/drops(passengers) on the way.
2. Car has a limited capacity to carry passengers.
3. Given a List of Trips i.e. trip[i] = [pickup_location,drop_Location,num_passengers] , find out whether it is possible to make all trips on the way or not.
NOTE: Car will only move in east directions i.e. no turn-around trip is possible.


Task is to "Find out whether it is possible to make all trips on the way[YES] or not[NO]".


Example 1 : 
    trip[] = [[1,5,2],[4,8,1],[11,15,3]]
    passengerCapacity : 3
    output : YES
    

Example 2 : 
    trip[] : [[1,3,5]]
    passengerCapacity : 4;
    output : NO

Example 3 :
    trip[] : []
    passengerCapacity : 2
    output : YES

Example 4 : 
    trip[] = [[1,5,2],[4,8,2],[11,15,3]]
    passengerCapacity : 3
    output : NO
*/

import java.util.*;

public class carPooling {
    public static boolean solve(int trips[][], int cap) {
        // write your code here
        Map<Integer, Integer> pickup = new HashMap<>(), drop = new HashMap<>();
        int people = 0, min = 1000, max = 0;
        for (int i = 0; i < trips.length; i++) {
            pickup.put(trips[i][0], trips[i][2]);
            drop.put(trips[i][1], trips[i][2]);
            min = Math.min(min, trips[i][0]);
            max = Math.max(max, trips[i][1]);
        }
        for (int i = min; i <= max; i++) {
            people += pickup.getOrDefault(i, 0);
            people -= drop.getOrDefault(i, 0);
            if (people > cap)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int trips[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            trips[i][0] = scn.nextInt();
            trips[i][1] = scn.nextInt();
            trips[i][2] = scn.nextInt();
        }
        int cap = scn.nextInt();
        scn.close();
        if (solve(trips, cap)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
