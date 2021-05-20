/*
1. Given a singly linklist, Segregate 012 Node of LinkedList and return pivot node of linkedlist.
2. After segregation zero nodes should come first and then ones node followed by two's nodes.
*/

import java.util.*;

public class segregate012NodeOfLinkedlist {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode zero = new ListNode(-1), one = new ListNode(-1), two = new ListNode(-1), h0 = zero, h1 = one, h2 = two,
                temp = head;
        while (temp != null) {
            ListNode backup = temp.next;
            if (temp.val == 0) {
                h0.next = temp;
                h0 = h0.next;
            } else if (temp.val == 1) {
                h1.next = temp;
                h1 = h1.next;
            } else {
                h2.next = temp;
                h2 = h2.next;
            }
            temp.next = null;
            temp = backup;
        }
        zero = zero.next;
        one = one.next;
        two = two.next;
        if (zero == null && one == null)
            return two;
        if (zero == null) {
            h1.next = two;
            return one;
        }
        if (one == null) {
            h0.next = two;
            return zero;
        }
        h0.next = one;
        h1.next = two;
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
        h1 = segregate012(h1);
        printList(h1);
    }
}
