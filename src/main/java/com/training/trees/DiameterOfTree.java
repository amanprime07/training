package com.training.trees;

public class DiameterOfTree {

    public static void main(String[] args) {
        // Constructed binary tree is
        //          5
        //        /   \
        //       8     6
        //      / \   /
        //     3   7 9
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(9);
        System.out.println(diameter(root));
    }

    private static int diameter(Node root) {
        int[] res = new int[1];
        diameter(root, res);
        return res[0];
    }

    private static int diameter(Node root, int[] res) {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = diameter(root.left, res);
        int rightTreeHeight = diameter(root.right, res);
        res[0] = Math.max(res[0], leftTreeHeight + rightTreeHeight);
        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }


}
