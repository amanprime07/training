package com.training.linkedlist.learn;

import com.training.linkedlist.ListNode;

public class SearchElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        ListNode head = ListNode.createList(arr);
        ListNode s = search(head, 3);
        System.out.println(s);

    }

    private static ListNode search(ListNode head, int v) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        while (temp != null && temp.v != v) {
            temp = temp.next;
        }
        return temp;
    }
}
