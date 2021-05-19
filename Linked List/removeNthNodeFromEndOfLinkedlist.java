/*
Given a singly linklist, remove the nth node from the end of the list and return its head.
*/

import java.util.*;

public class removeNthNodeFromEndOfLinkedlist {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int size(ListNode head) {
        if (head == null)
            return 0;
        ListNode temp = head;
        int size = 1;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int x = size(head) - n;
        if (x < 0)
            return head;
        if (x == 0)
            return head.next;
        ListNode temp = head;
        while (x-- > 1) {
            temp = temp.next;
        }
        if (temp.next == null)
            return head;
        if (temp.next.next == null)
            temp.next = null;
        else
            temp.next = temp.next.next;
        return head;
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

        int m = scn.nextInt();
        removeNthFromEnd(h1, m);
        printList(h1);
    }
}
