package com.training.doublyLinkedList;

public class Node {
    int v;
    Node next;
    Node prev;

    public Node(int v) {
        this.v = v;
    }

    public Node(int v, Node prev, Node next) {
        this.v = v;
        this.prev = prev;
        this.next = next;
    }

    public static Node createList(int[] arr) {
        Node head = null;
        if (arr.length == 0) {
            return head;
        }
        head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i], temp, null);
            temp = temp.next;

        }
        return head;
    }
}
