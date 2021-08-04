/*
Implement the MapSum class:
1. MapSum() Initializes the MapSum object.
2. void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
3. int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
*/

import java.io.*;

public class mapSumPairs {
    public static class MapSum {
        class Node {
            Node[] children;
            int sum;

            Node() {
                children = new Node[26];
                sum = 0;
            }
        }

        Node root;

        /** Initialize your data structure here. */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node curr = root;
            for (char ch : key.toCharArray()) {
                if (curr.children[ch - 'a'] == null)
                    curr.children[ch - 'a'] = new Node();
                curr = curr.children[ch - 'a'];
            }
            curr.sum = val;
        }

        public int sum(String prefix) {
            Node curr = root;
            for (char ch : prefix.toCharArray()) {
                if (curr.children[ch - 'a'] == null)
                    curr.children[ch - 'a'] = new Node();
                curr = curr.children[ch - 'a'];
            }
            return getValue(curr);
        }

        public int getValue(Node curr) {
            if (curr == null)
                return 0;
            int sum = curr.sum;
            for (int i = 0; i < 26; i++)
                sum += getValue(curr.children[i]);
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        MapSum obj = new MapSum();

        while (read.ready()) {
            String inp[] = read.readLine().split(" ");
            if (inp[0].equals("exit"))
                break;

            if (inp.length == 2) {
                obj.insert(inp[0], Integer.parseInt(inp[1]));
            } else {
                System.out.println(obj.sum(inp[0]));
            }
        }
    }
}
