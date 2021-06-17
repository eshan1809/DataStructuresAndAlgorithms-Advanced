/*
Design your implementation of the circular double-ended queue (deque).

Your implementation should support following operations:

1. MyCircularDeque(): Initializes the deque object.
2. insertFront(): Adds an item at the front of Deque.
3. insertLast(): Adds an item at the rear of Deque.
4. deleteFront(): Deletes the front item from the Deque and return it's value. If the deque is empty, return null.
5. deleteLast(): Deletes the last item from Deque and return it's value. If the deque is empty, return null.
6. getFront(): Gets the front item from the Deque. If the deque is empty, return null.
7. getRear(): Gets the last item from Deque. If the deque is empty, return null.
8. isEmpty(): Checks whether Deque is empty or not.
*/

import java.io.*;
import java.util.*;

public class designCircularDeque {
    public static class MyCircularDeque<T> {
        LinkedList<T> list;
        int size;

        /** Initialize your data structure here. */
        public MyCircularDeque() {
            list = new LinkedList<T>();
            size = 0;
        }

        /**
         * Adds an item at the front of Deque.
         */
        public void insertFront(T value) {
            list.addFirst(value);
            size++;
        }

        /**
         * Adds an item at the rear of Deque.
         */
        public void insertLast(T value) {
            list.addLast(value);
            size++;
        }

        /**
         * Deletes the front item from the Deque and return it's value. If the deque is
         * empty, return null.
         */
        public T deleteFront() {
            if (size == 0)
                return null;
            size--;
            return list.removeFirst();
        }

        /**
         * Deletes the last item from Deque and return it's value. If the deque is
         * empty, return null.
         */
        public T deleteLast() {
            if (size == 0)
                return null;
            size--;
            return list.removeLast();
        }

        /** Gets the front item from the Deque. If the deque is empty, return null. */
        public T getFront() {
            if (size == 0)
                return null;
            return list.getFirst();
        }

        /** Gets the last item from Deque. If the deque is empty, return null. */
        public T getRear() {
            if (size == 0)
                return null;
            return list.getLast();
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        MyCircularDeque<Integer> obj = new MyCircularDeque<>();

        while (read.ready()) {
            String inp[] = read.readLine().split(" ");
            String s = inp[0];

            if (s.equals("insertLast")) {
                obj.insertLast(Integer.parseInt(inp[1]));
            } else if (s.equals("insertFront")) {
                obj.insertFront(Integer.parseInt(inp[1]));
            } else if (s.equals("deleteFront")) {
                System.out.println(obj.deleteFront());
            } else if (s.equals("deleteLast")) {
                System.out.println(obj.deleteLast());
            } else if (s.equals("getFront")) {
                System.out.println(obj.getFront());
            } else if (s.equals("getRear")) {
                System.out.println(obj.getRear());
            } else if (s.equals("isEmpty")) {
                System.out.println(obj.isEmpty());
            }
        }

    }
}
