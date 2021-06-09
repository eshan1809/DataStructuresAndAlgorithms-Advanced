/*
1. Given a singly linklist, Segregate Node of LinkedList over pivot index and return starting node of linkedlist.
2. pivot will be any random index in range of 0 to length Of Linkedlist
3. After segregation pivot Element should have to be present at correct position as in sorted linkedlist.
*/

import java.util.*;

public class segregateNodeOfLinkedlistOverPivotIndex {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate(ListNode head, int pivotIdx) {
        if (head == null)
            return null;
        ListNode temp = head;
        int idx = pivotIdx;
        while (idx-- != 0)
            temp = temp.next;
        int pivotElement = temp.val;
        ListNode less = new ListNode(0), l = less, more = new ListNode(0), m = more, pivot = null;
        temp = head;
        while (temp != null) {
            if (pivotIdx-- == 0)
                pivot = temp;
            else if (temp.val <= pivotElement)
                l = l.next = temp;
            else
                m = m.next = temp;
            temp = temp.next;
        }
        less = less.next;
        more = more.next;
        l.next = pivot;
        pivot.next = more;
        m.next = null;
        if (less == null)
            return pivot;
        return less;
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
        int idx = scn.nextInt();
        h1 = segregate(h1, idx);
        printList(h1);
    }
}
