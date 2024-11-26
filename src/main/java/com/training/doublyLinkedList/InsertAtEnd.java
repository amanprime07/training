package com.training.doublyLinkedList;

public class InsertAtEnd {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        Node head = Node.createList(arr);
        print(head);
        insert(head, 5);
        print(head);

    }

    // 1<->2<->3<->null
    private static Node insert(Node head, int v) {
        if (head == null) {
            return new Node(v);
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(v, temp, null);
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
