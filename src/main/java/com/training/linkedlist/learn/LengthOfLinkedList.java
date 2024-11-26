package com.training.linkedlist.learn;

import com.training.linkedlist.Node;

// learn traversal
public class LengthOfLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Node head = Node.createList(arr);
        int n = length(head);
        System.out.println(n);
        arr = new int[0];
        head = Node.createList(arr);
        n = length(head);
        System.out.println(n);
    }

    private static int length(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
