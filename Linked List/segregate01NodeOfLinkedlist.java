/*
1. Given a singly linklist, Segregate 01 Node of LinkedList and return pivot node of linkedlist.
2. After segregation zero nodes should come first and followed by ones node.
*/

import java.util.*;

public class segregate01NodeOfLinkedlist {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
        ListNode zero = new ListNode(-1), one = new ListNode(-1), h0 = zero, h1 = one, temp = head;
        while (temp != null) {
            ListNode backup = temp.next;
            if (temp.val == 0) {
                h0.next = temp;
                h0 = h0.next;
            } else if (temp.val == 1) {
                h1.next = temp;
                h1 = h1.next;
            }
            temp.next = null;
            temp = backup;
        }
        zero = zero.next;
        one = one.next;
        if (zero == null)
            return one;
        if (one == null)
            return zero;
        h0.next = one;
        return zero;
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
        h1 = segregate01(h1);
        printList(h1);
    }
}
