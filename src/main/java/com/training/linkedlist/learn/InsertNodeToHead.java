package com.training.linkedlist.learn;

import com.training.linkedlist.Node;

public class InsertNodeToHead {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Node n = Node.createList(arr);
        Node head = addToHead(5, n);
        System.out.println(head);
    }

    private static Node addToHead(int v, Node head) {
        Node n = new Node(v, head);
        return n;
    }
}


