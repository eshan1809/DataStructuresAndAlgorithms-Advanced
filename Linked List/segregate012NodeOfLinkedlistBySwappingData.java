/*
1. Given a singly linklist, Segregate 012 Node of LinkedList and return pivot node of linkedlist.
2. After segregation zero nodes should come first and then ones node followed by two's nodes.
3. You are only allowed to swap data not swap nodes.
*/

import java.util.*;

public class segregate012NodeOfLinkedlistBySwappingData {
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
        ListNode t1 = head, t2 = head;
        while (t2 != null) {
            if (t2.val == 0) {
                int x = t2.val;
                t2.val = t1.val;
                t1.val = x;
                t1 = t1.next;
            }
            t2 = t2.next;
        }
        t2 = t1;
        while (t2 != null) {
            if (t2.val == 1) {
                int x = t2.val;
                t2.val = t1.val;
                t1.val = x;
                t1 = t1.next;
            }
            t2 = t2.next;
        }
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
        h1 = segregate012(h1);
        printList(h1);
    }
}
