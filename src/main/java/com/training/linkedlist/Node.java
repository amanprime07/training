package com.training.linkedlist;

public class Node {
    public int v;
    public Node next;

    public Node(int v) {
        this.v = v;
        this.next = null;
    }

    public Node(int v, Node n) {
        this.v = v;
        this.next = n;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + v +
                ", next=" + next +
                '}';
    }

    public static Node createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }
}