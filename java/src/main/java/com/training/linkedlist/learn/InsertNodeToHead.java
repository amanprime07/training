package com.training.linkedlist.learn;

import com.training.linkedlist.ListNode;

public class InsertNodeToHead {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode n = ListNode.createList(arr);
        ListNode head = addToHead(5, n);
        System.out.println(head);
    }

    private static ListNode addToHead(int v, ListNode head) {
        ListNode n = new ListNode(v, head);
        return n;
    }
}


