package com.training.linkedlist.medium;

import com.training.linkedlist.ListNode;

public class SegregateOddEvenNodes {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createList(arr);
        head = segregate(head);
        head.print();
    }

    private static ListNode segregate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = new ListNode(-1);
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode(-1);
        ListNode evenTail = evenHead;
        ListNode curr = head, temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = null;
            if (curr.v % 2 == 0) {
                // even
                evenTail = append(evenTail, curr);
            } else {
                // odd
                oddTail = append(oddTail, curr);
            }
            curr = temp;
        }
        evenHead = evenHead.next;
        oddHead = oddHead.next;
        if (evenHead == null) {
            evenHead = oddHead;
            return evenHead;
        }
        append(evenTail, oddHead);
        return evenHead;
    }

    private static ListNode append(ListNode tail, ListNode n) {
        if (tail == null) {
            tail = n;
        }
        tail.next = n;
        return n;
    }
}
