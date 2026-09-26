package com.training.doublyLinkedList;


public class DeleteNode {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Node head = Node.createList(arr);
        print(head);
        head = deleteTail(head);
        print(head);
        head = deleteHead(head);
        print(head);

    }

    private static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head.next;
        temp.prev = null;
        head.next = null;
        return temp;
    }

    private static Node deleteTail(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        curr.prev = null;

        return head;
    }

    private static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.v + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
