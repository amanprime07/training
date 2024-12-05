package com.training.linkedlist.medium;

import com.training.linkedlist.Node;

public class SegregateOddEvenNodes {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = Node.createList(arr);
        head = segregate(head);
        head.print();
    }

    private static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node oddHead = new Node(-1);
        Node oddTail = oddHead;
        Node evenHead = new Node(-1);
        Node evenTail = evenHead;
        Node curr = head, temp;

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

    private static Node append(Node tail, Node n) {
        if (tail == null) {
            tail = n;
        }
        tail.next = n;
        return n;
    }
}
