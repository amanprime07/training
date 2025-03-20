package com.training.trees;

import java.util.Stack;

public class InOrderTraversal {

    private static void inOrderTraversalRecursive(StringTreeNode root) {
        if (root == null)
            return;
        inOrderTraversalRecursive(root.left);
        System.out.print(root.value + " ");
        inOrderTraversalRecursive(root.right);
    }

    public static void main(String[] args) {
        StringTreeNode root = StringTreeNode.getTree();
        inOrderTraversalRecursive(root);
        System.out.println();
        inOrderTraversalIterative(root);
    }

    private static void inOrderTraversalIterative(StringTreeNode root) {
        Stack<StringTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.value + " ");
            root = root.right;
        }
    }
}
