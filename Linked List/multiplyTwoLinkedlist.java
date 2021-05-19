/*
1. You are given two single linkedlist of digits. 
2. The most significant digit comes first and each of their nodes contain a single digit. Multiply the two numbers and return it as a linked list.
3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

import java.util.*;

public class multiplyTwoLinkedlist {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0), temp = head, c1 = l1, c2 = l2;
        int carry = 0;
        while (c1 != null && c2 != null) {
            temp.next = new ListNode(0);
            temp = temp.next;
            int sum = c1.val + c2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.val = sum;
            c1 = c1.next;
            c2 = c2.next;
        }
        while (c1 != null) {
            temp.next = new ListNode(0);
            temp = temp.next;
            int sum = c1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.val = sum;
            c1 = c1.next;
        }
        while (c2 != null) {
            temp.next = new ListNode(0);
            temp = temp.next;
            int sum = c2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.val = sum;
            c2 = c2.next;
        }
        if (carry > 0)
            temp.next = new ListNode(carry);
        return head.next;
    }

    public static ListNode multiplyByDigit(ListNode l, int digit) {
        if (digit == 0)
            return new ListNode(0);
        ListNode head = new ListNode(0), temp = head, c = l;
        int carry = 0;
        while (c != null) {
            temp.next = new ListNode(0);
            temp = temp.next;
            int sum = c.val * digit + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.val += sum;
            c = c.next;
        }
        if (carry > 0)
            temp.next = new ListNode(carry);
        return head.next;
    }

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode c2 = l2;
        int t = 0;
        ListNode prev = null;
        while (c2 != null) {
            ListNode n = multiplyByDigit(l1, c2.val);
            int i = t;
            while (i-- > 0) {
                ListNode node = new ListNode(0);
                node.next = n;
                n = node;
            }
            prev = addTwoNumbers(prev, n);
            t++;
            c2 = c2.next;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        return reverse(prev);
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

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }
}
