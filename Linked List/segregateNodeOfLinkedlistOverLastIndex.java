/*
1. Given a singly linklist, Segregate Node of LinkedList over lastindex and return pivot node of linkedlist.
2. pivot is always be last index of linkedlist.
3. After segregation pivot Element should have to be present at correct position as in sorted linkedlist.
*/

import java.util.*;

class segregateNodeOfLinkedlistOverLastIndex {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        if (head == null)
            return null;
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        int pivot = temp.val;
        ListNode less = new ListNode(0), l = less, more = new ListNode(0), m = more;
        temp = head;
        while (temp.next != null) {
            if (temp.val <= pivot) {
                l.next = temp;
                l = l.next;
            } else {
                m.next = temp;
                m = m.next;
            }
            temp = temp.next;
        }
        l.next = null;
        m.next = null;
        less = less.next;
        more = more.next;
        temp.next = more;
        if (less != null)
            l.next = temp;
        return temp;
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
        scn.close();
    }
}