/*
1. Convert a sorted Doubly-Linked List to a Balanced Binary Search Tree in place.
2. The previous and next pointers in nodes are to be used as left and right pointers respectively in converted Binary Search Tree. 
3. The tree must be constructed in-place (No new node should be allocated for tree conversion) 
*/

import java.util.*;

class convertSortedDoublyLinkedListToBinarySearchTree {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node midNode(Node head) {
        Node slow = head, fast = head;
        while (fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    // left : prev, right : next
    public static Node SortedDLLToBST(Node head) {
        Node root = midNode(head);
        if (root.left != null) {
            root.left.right = null;
            root.left = SortedDLLToBST(head);
        }
        if (root.right != null) {
            root.right.left = null;
            root.right = SortedDLLToBST(root.right);
        }
        return root;
    }

    // Input_code===================================================

    public static void display(Node node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static Node makeList(int n) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        while (n-- > 0) {
            Node node = new Node(scn.nextInt());
            prev.right = node;
            node.left = prev;
            prev = prev.right;
        }

        Node head = dummy.right;
        head.left = dummy.right = null;

        return head;
    }

    public static void main(String[] args) {
        Node head = makeList(scn.nextInt());

        head = SortedDLLToBST(head);
        display(head);
    }

}