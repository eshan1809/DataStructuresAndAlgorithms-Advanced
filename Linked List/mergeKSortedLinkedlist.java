/*
You are given an array of k linked-lists, each linked-list is sorted in increasing order.
Merge all the linkedlists into one sorted linkedlist and return it.
*/

import java.util.*;

public class mergeKSortedLinkedlist {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int idx, val;

        Pair(int i, int v) {
            idx = i;
            val = v;
        }

        public int compareTo(Pair o) {
            if (this.val != o.val)
                return this.val - o.val;
            else
                return this.idx - o.idx;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0), temp = head;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int flag = 0;
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null) {
                flag = 1;
                pq.add(new Pair(i, lists[i].val));
                lists[i] = lists[i].next;
            }
        if (flag == 0)
            return null;
        while (pq.size() > 0) {
            Pair p = pq.remove();
            temp.next = new ListNode(0);
            temp = temp.next;
            temp.val = p.val;
            if (lists[p.idx] != null) {
                pq.add(new Pair(p.idx, lists[p.idx].val));
                lists[p.idx] = lists[p.idx].next;
            }
        }
        return head.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }
        scn.close();
        ListNode head = mergeKLists(list);
        printList(head);
    }
}
