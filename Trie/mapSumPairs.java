/*
Implement the MapSum class:
1. MapSum() Initializes the MapSum object.
2. void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
3. int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
*/

public class mapSumPairs {
    public static class MapSum {

        /** Initialize your data structure here. */
        public MapSum() {

        }

        public void insert(String key, int val) {

        }

        public int sum(String prefix) {

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
