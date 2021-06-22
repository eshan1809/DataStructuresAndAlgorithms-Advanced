/*
1. Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
2. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. 
3. The order of nodes in DLL must be the same as in Inorder for the given Binary Search Tree. The first node of Inorder traversal (leftmost node in BST) must be the head node of the DLL. 
*/

import java.util.Scanner;
import java.util.LinkedList;

public class convertBinarySearchTreeToDoublyLinkedList {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static class BSTIterator {
        LinkedList<Node> list;

        private void addAllLeft(Node node) {
            while (node != null) {
                list.addFirst(node);
                node = node.left;
            }
        }

        public BSTIterator(Node root) {
            list = new LinkedList<>();
            addAllLeft(root);
        }

        public int next() {
            Node node = list.removeFirst();
            addAllLeft(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return list.size() > 0;
        }
    }

    public static Node bToDLL(Node root) {
        BSTIterator itr = new BSTIterator(root);
        if (itr.hasNext()) {
            Node list = new Node(itr.next()), temp = list;
            while (itr.hasNext()) {
                temp.right = new Node(itr.next());
                temp.right.left = temp;
                temp = temp.right;
            }
            return list;
        }
        return null;
    }

    // input_section=================================================

    public static void display(Node node) {
        Node head = node;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
            if (node == head)
                break;
        }

    }

    public static Node constructFromInOrder_(int[] in, int si, int ei) {
        if (si > ei)
            return null;

        int mid = (si + ei) / 2;
        Node node = new Node(in[mid]);

        node.left = constructFromInOrder_(in, si, mid - 1);
        node.right = constructFromInOrder_(in, mid + 1, ei);

        return node;
    }

    public static Node constructFromInOrder(int[] inOrder) {
        int n = inOrder.length;
        return constructFromInOrder_(inOrder, 0, n - 1);
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        Node root = constructFromInOrder(in);
        root = bToDLL(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}