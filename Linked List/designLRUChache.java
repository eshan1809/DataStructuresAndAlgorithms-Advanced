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

Note -> Use the code snippet. The judge can't force you but the intention is to teach a concept. Play in spirit of the question.
*/

import java.util.*;

public class designLRUChache {
    static class Node {
        int key, val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public static class LRUCache {
        Node head, tail;
        int size, capacity;
        Map<Integer, Node> map;

        public LRUCache(int capacity) {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
            this.size = 0;
            map = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            Node node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }

        // appp name, app state
        public void put(int key, int value) {
            if (map.containsKey(key)) {
                removeNode(map.get(key));
                map.get(key).val = value;
                addNode(map.get(key));
                return;
            }
            size++;
            map.put(key, new Node(key, value));
            addNode(map.get(key));
            if (size > capacity) {
                size--;
                Node node = tail.prev;
                map.remove(node.key);
                removeNode(node);
            }
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addNode(Node node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
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