/*
Given a singly linked list of Integers, determine it is a palindrome or not.
*/

import java.util.*;

public class palindromeLinkedlist {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode midNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
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

    public static boolean isPalindrome(ListNode head) {
        ListNode mid = midNode(head), temp = head;
        mid = reverse(mid);
        while (mid.next != null) {
            if (temp.val != mid.val)
                return false;
            mid = mid.next;
            temp = temp.next;
        }
        return true;
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
        System.out.println(isPalindrome(dummy.next));
    }
}
