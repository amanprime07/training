package com.training.linkedlist.learn;

import com.training.linkedlist.Node;

public class DeleteNode {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Node temp = Node.createList(arr);
        System.out.println(temp);
        temp = deleteTail(temp);
        System.out.println(temp);
        temp = deleteHead(temp);
        System.out.println(temp);
    }

    private static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head.next;
        head.next = null;
        return temp;
    }

    // 1->2->3->null
    private static Node deleteTail(Node head) {
        // base case
        if (head == null || head.next == null) {
            return null;
        }
        Node curr = head;
        Node prev = null;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }
}
