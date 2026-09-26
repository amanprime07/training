package concentrix;

public class LinkedListSolution {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private static class LinkedList {
        Node head;

        public LinkedList() {
            head = null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public void remove(int data) {
            if (head == null) {
                return;
            }
            if (head.data == data) {
                head = head.next;
                return;
            }
            Node temp = head;
            Node prev = null;
            while (temp != null) {
                if (temp.data == data) {
                    prev.next = temp.next;
                    return;
                }
                prev = temp;
                temp = temp.next;
            }
        }

        public void traverse() {
            if (head == null) {
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

//        1 -> 2-> null
        public void reverse() {
            if (head == null) {
                return;
            }
            Node prev = null;
            Node current = head;
            Node next;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
    }

//    add 1
//    add 2
//    add 3
//    traverse
//    add 4
//    add 5
//    traverse
//    remove 3
//    traverse
//    reverse
//    traverse
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.traverse();
        l.add(4);
        l.add(5);
        l.traverse();
        l.remove(3);
        l.traverse();
        l.reverse();
        l.traverse();
    }
}
