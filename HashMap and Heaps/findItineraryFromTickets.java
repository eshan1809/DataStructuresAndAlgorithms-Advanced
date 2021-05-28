/*
1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
2. You have to find the itinerary in order using the given list of tickets.

Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination.
*/

import java.util.*;

public class findItineraryFromTickets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap<String, String> map = new HashMap<>();
        Set<String> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int i = 0; i < noofpairs_src_des; i++) {
            String s1 = scn.next();
            String s2 = scn.next();
            set1.add(s1);
            set2.add(s2);
            map.put(s1, s2);
        }
        scn.close();

        // write your code here
        String origin = "";
        for (String s : set1) {
            if (!set2.contains(s)) {
                origin = s;
                break;
            }
        }
        String ans = origin;
        while (map.containsKey(origin)) {
            origin = map.get(origin);
            ans += " -> " + origin;
        }
        System.out.println(ans + ".");
    }
}
