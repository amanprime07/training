package com.training.trees;

import java.util.Stack;

public class ValidateBST {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(12);
        root.left.left = new Node(1);
        root.right.left = new Node(11);
        root.right.right = new Node(13);
        System.out.println(isValid(root));
        System.out.println(isValidStack(root));

    }

    private static boolean isValid(Node root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValid(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (!(min < root.value && root.value < max)) {
            return false;
        }
        return isValid(root.left, min, root.value) && isValid(root.right, root.value, max);
    }

    private static boolean isValidStack(Node root) {
        if (root == null) {
            return true;
        }
        Stack<Triplet> stack = new Stack<>();
        stack.push(new Triplet(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while (!stack.isEmpty()) {
            Triplet t = stack.pop();
            Node n = t.val;
            if (!(t.min < n.value && n.value < t.max)) {
                return false;
            } else {
                if (n.left != null) {
                    stack.push(new Triplet(n.left, t.min, n.value));
                }
                if (n.right != null) {
                    stack.push(new Triplet(n.right, n.value, t.max));
                }
            }
        }
        return true;
    }

    private static class Triplet {
        Node val;
        int min;
        int max;

        public Triplet(Node val, int min, int max) {
            this.val = val;
            this.min = min;
            this.max = max;
        }
    }

    private static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
