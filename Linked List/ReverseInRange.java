/*
1. Given a singly linklist, Reverse a linkedlist from position starting position to end position.
2. Do it in one-pass. without using any extra space.
3. Indexing start from numeric 1.
*/

import java.util.*;

public class ReverseInRange {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }

    public static ListNode reverseInRange(ListNode head, int n, int m) {
        ListNode first, mid, end, t1 = head, t2;
        int i = 2;
        if (n == 1) {
            first = null;
            mid = head;
            t2 = head;
        } else {
            first = head;
            while (i < n) {
                t1 = t1.next;
                i++;
            }
            i++;
            mid = t1.next;
            t1.next = null;
            t2 = mid;
        }
        while (i <= m) {
            t2 = t2.next;
            i++;
        }
        end = t2.next;
        t2.next = null;
        t2 = reverse(mid);
        if (first == null) {
            mid.next = end;
            return t2;
        } else {
            t1.next = t2;
            mid.next = end;
            return first;
        }
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    }
}
