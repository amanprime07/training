package com.training.linkedlist.learn;

import com.training.linkedlist.ListNode;

// learn traversal
public class LengthOfLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode head = ListNode.createList(arr);
        int n = length(head);
        System.out.println(n);
        arr = new int[0];
        head = ListNode.createList(arr);
        n = length(head);
        System.out.println(n);
    }

    private static int length(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
