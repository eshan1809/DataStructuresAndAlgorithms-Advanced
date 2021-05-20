/*
Design a stack which supports the following operations.

Implement the CustomStack class:

    1: void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
    2: int pop() Pops and returns the top of stack or -1 if the stack is empty.
    3: void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack.
*/

import java.io.*;

public class designAStackWithIncrementOperation {
    public static class CustomStack {

        int value[];
        int increment[];
        int index;

        public CustomStack(int maxSize) {
            value = new int[maxSize];
            increment = new int[maxSize];
            index = -1;
        }

        public void push(int x) {
            // complete this function
            if (index < value.length - 1)
                value[++index] = x;
        }

        public int pop() {
            // complete this function
            if (index >= 0) {
                int x = increment[index];
                if (index > 0)
                    increment[index - 1] += x;
                increment[index] = 0;
                return x + value[index--];
            }
            return -1;
        }

        public void increment(int k, int val) {
            // complete this function
            if (k <= index + 1)
                increment[k - 1] += val;
            else if (index >= 0)
                increment[index] += val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int maxsize = Integer.parseInt(read.readLine());

        CustomStack cs = new CustomStack(maxsize);

        while (true) {
            String task[] = read.readLine().split(" ");
            if (task[0].equals("push")) {
                cs.push(Integer.parseInt(task[1]));
            } else if (task[0].equals("pop")) {
                System.out.println(cs.pop());
            } else if (task[0].equals("increment")) {
                cs.increment(Integer.parseInt(task[1]), Integer.parseInt(task[2]));
            } else {
                break;
            }
        }
        System.out.println("exit");
    }
}
