package com.striver79;

import com.training.linkedlist.ListNode;

public class RemoveNthNodeFromLast {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createList(arr);
        ListNode res = removeNthFromEnd(head, 5);
        res.print();
        System.out.println();
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode curr = head, prev = null;
        while (fast != null) {
            prev = curr;
            curr = curr.next;
            fast = fast.next;
        }
        if (prev == null) {
            if (curr != null) {
                head = head.next;
                return head;
            }
            return null;
        }
        prev.next = curr.next;
        return head;
    }

    private static ListNode removeNthFromEndExtraNode(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode curr = new ListNode(0, head), temp = curr;
        while (fast != null) {
            temp = temp.next;
            fast = fast.next;
        }
        temp.next = temp.next.next;
        return curr.next;
    }
}
