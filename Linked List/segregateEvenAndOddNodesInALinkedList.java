/*
Given a singly linklist, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.
*/

import java.util.*;

public class segregateEvenAndOddNodesInALinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode even = new ListNode(-1), odd = new ListNode(-1), h1 = even, h2 = odd, h = head;
        while (h != null) {
            if (h.val % 2 == 0) {
                h1.next = h;
                h1 = h1.next;
                h = h.next;
            } else {
                h2.next = h;
                h2 = h2.next;
                h = h.next;
            }
        }
        h1.next = odd.next;
        h2.next = null;
        even = even.next;
        return even;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }
        scn.close();
        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
