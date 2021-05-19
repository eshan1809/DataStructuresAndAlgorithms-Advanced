/*
1. Given a singly linklist, reverse the nodes of a linked list k at a time and return its modified linkedlist.
2. If number of nodes in multiple of k then it will reverse otherwise it will add inn the end of linkedlist without any change.
*/

import java.util.*;

public class reverseNodeOfLinkedlistInKGroup {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode th = null, tt = null;

    public static void addFirst(ListNode node) {
        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public static int size(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        ListNode oh = null, ot = null, curr = head;
        int s = size(head);
        if (s < k || k == 0)
            return head;
        while (s >= k) {
            int i = k;
            while (i-- > 0) {
                ListNode f = curr.next;
                addFirst(curr);
                curr = f;
            }
            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }
            th = tt = null;
            s -= k;
        }
        ot.next = curr;
        return oh;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}
