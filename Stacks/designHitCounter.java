/*
Design a hit counter which counts the number of hits received in the past 5 minutes (i.e., the past 300 seconds).

Your system should accept a timestamp parameter (in seconds granularity), and you may assume that calls are being made to the system in chronological order (i.e., timestamp is monotonically increasing). Several hits may arrive roughly at the same time.

Implement the HitCounter class:

HitCounter() Initializes the object of the hit counter system.
void hit(int timestamp) Records a hit that happened at timestamp (in seconds). Several hits may happen at the same timestamp.
int getHits(int timestamp) Returns the number of hits in the past 5 minutes from timestamp (i.e., the past 300 seconds).
*/

import java.util.*;

public class designHitCounter {

    static class HitCounter {

        Stack<Integer> st;

        /** Initialize your data structure here. */
        public HitCounter() {
            st = new Stack<>();
        }

        /**
         * Record a hit.
         * 
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            st.push(timestamp);
        }

        /**
         * Return the number of hits in the past 5 minutes.
         * 
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            Stack<Integer> temp = new Stack<>();
            while (!st.isEmpty() && st.peek() > timestamp - 300)
                temp.push(st.pop());
            int ans = temp.size();
            while (!temp.isEmpty())
                st.push(temp.pop());
            return ans;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {

        Scanner scn = new Scanner(System.in);

        HitCounter obj = new HitCounter();
        while (true) {
            String in = scn.next();

            if (in.equals("hit")) {
                obj.hit(scn.nextInt());
            } else if (in.equals("getHits")) {
                System.out.println(obj.getHits(scn.nextInt()));
            } else {
                break;
            }
        }
        scn.close();
    }
}
