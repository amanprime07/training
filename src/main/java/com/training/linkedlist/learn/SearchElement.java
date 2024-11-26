package com.training.linkedlist.learn;

import com.training.linkedlist.Node;

public class SearchElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        Node head = Node.createList(arr);
        Node s = search(head, 3);
        System.out.println(s);

    }

    private static Node search(Node head, int v) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null && temp.v != v) {
            temp = temp.next;
        }
        return temp;
    }
}
