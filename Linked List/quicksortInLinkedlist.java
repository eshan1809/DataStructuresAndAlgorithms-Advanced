/*
1. Given the head of a linked list, return the list after sorting it in increasing order.
2. You must apply quick sort.
3. Time Complexity : O(nlogn)
4. Space Complexity : constant space 
*/

import java.util.*;

class quicksortInLinkedlist {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static class Pair {
        ListNode l1, l2;

        Pair(ListNode a, ListNode b) {
            l1 = a;
            l2 = b;
        }
    }

    public static Pair segregateOnLastIndex(ListNode head) {
        if (head == null)
            return null;
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        int pivot = temp.val;
        ListNode less = new ListNode(0), l = less, more = new ListNode(0), m = more;
        temp = head;
        while (temp.next != null) {
            if (temp.val < pivot) {
                l.next = temp;
                l = l.next;
            } else {
                m.next = temp;
                m = m.next;
            }
            temp = temp.next;
        }
        less = less.next;
        more = more.next;
        l.next = null;
        m.next = null;
        temp.next = more;
        return new Pair(less, temp);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        ListNode head = new ListNode(0), temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            temp.next = l1;
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            temp.next = l2;
            temp = temp.next;
            l2 = l2.next;
        }
        return head.next;
    }

    public static boolean isSorted(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode temp = head;
        int val = head.val;
        while (temp.next != null) {
            temp = temp.next;
            if (val > temp.val)
                return false;
            val = temp.val;
        }
        return true;
    }

    public static ListNode quickSort(ListNode head) {
        if (isSorted(head))
            return head;
        Pair p = segregateOnLastIndex(head);
        ListNode h1 = quickSort(p.l1), h2 = quickSort(p.l2);
        return mergeTwoLists(h1, h2);
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
        ListNode h1 = createList(n);

        ListNode head = quickSort(h1);
        printList(head);
    }
}