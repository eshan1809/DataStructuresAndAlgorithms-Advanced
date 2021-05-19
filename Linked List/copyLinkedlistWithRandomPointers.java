/*
1. Given a singly linklist with an additional random pointer which could point to any node in the list or NULL.
2. Return a deep copy of the list.
*/

import java.util.*;

public class copyLinkedlistWithRandomPointers {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = new ListNode(curr.val);
            map.put(curr, temp);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            ListNode temp = map.get(curr);
            temp.next = map.get(curr.next);
            temp.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if (idx != -1)
                arr[i].random = arr[idx];
        }
        scn.close();

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}
