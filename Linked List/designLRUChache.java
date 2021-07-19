/*
1. Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

2. Discards the least recently used items first. This algorithm requires keeping track of what 
   was used when, which is expensive if one wants to make sure the algorithm always discards 
   the least recently used item. General implementations of this technique require keeping 
   "age bits" for cache-lines and track the "Least Recently Used" cache-line based on age-bits. 
   In such an implementation, every time a cache-line is used, the age of all other cache-lines changes
   
3. mplement the LRUCache class: 
      3.1 LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
      3.2 int get(int key) Return the value of the key if the key exists, otherwise return -1.
      3.3 void put(int key, int value) Update the value of the key if the key exists. Otherwise, 
          add the key-value pair to the cache. If the number of keys exceeds the capacity from this 
          operation, evict the least recently used key.

4. Could you do get and put in O(1) time complexity? 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
        force you but the intention is to teach a concept. Play in spirit of the question.
*/

import java.util.*;

public class designLRUChache {
    public static class LRUCache {
        LinkedHashMap<Integer, Integer> map;
        int capacity;
        int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                public boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        // appp name, app state
        public void put(int key, int value) {
            map.put(key, value);
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // no of operations
        // 0 stand for put, 1 stand for get
        int size = scn.nextInt();
        LRUCache lru = new LRUCache(size);

        while (n-- > 0) {
            int op = scn.nextInt();
            if (op == 0)
                lru.put(scn.nextInt(), scn.nextInt());
            else
                System.out.println(lru.get(scn.nextInt()));
        }
        scn.close();
    }
}
