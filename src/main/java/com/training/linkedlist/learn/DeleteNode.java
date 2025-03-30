package com.training.linkedlist.learn;

import com.training.linkedlist.ListNode;

public class DeleteNode {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode temp = ListNode.createList(arr);
        System.out.println(temp);
        temp = deleteTail(temp);
        System.out.println(temp);
        temp = deleteHead(temp);
        System.out.println(temp);
    }

    private static ListNode deleteHead(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode temp = head.next;
        head.next = null;
        return temp;
    }

    // 1->2->3->null
    private static ListNode deleteTail(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return null;
        }
        ListNode curr = head;
        ListNode prev = null;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }
}
