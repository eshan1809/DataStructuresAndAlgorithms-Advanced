/*
1. You are give two single linkedlist of digits. 
2. The most significant digit comes first and each of their nodes contain a single digit. Subtract the two numbers and return it as a linked list.
3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

import java.util.*;

public class subtractTwoLinkedlist {
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

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0), temp = head, c1 = reverse(l1), c2 = reverse(l2);
        int borrow = 0;
        while (c1 != null && c2 != null) {
            temp.next = new ListNode(0);
            temp = temp.next;
            int diff = c1.val - c2.val - borrow;
            if (diff < 0) {
                borrow = 1;
                diff += 10;
            } else
                borrow = 0;
            temp.val = diff;
            c1 = c1.next;
            c2 = c2.next;
        }
        while (c1 != null) {
            temp.next = new ListNode(0);
            temp = temp.next;
            int diff = c1.val - borrow;
            if (diff < 0) {
                borrow = 1;
                diff += 10;
            } else
                borrow = 0;
            temp.val = diff;
            c1 = c1.next;
        }
        head = head.next;
        return reverse(head);
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = subtractTwoNumbers(head1, head2);
        printList(ans);
    }
}
