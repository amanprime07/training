package com.training.trees;

import java.util.Stack;

public class PostOrderTraversal {

    private static void postOrderTraversalRecursive(StringTreeNode root) {
        if (root == null)
            return;
        postOrderTraversalRecursive(root.left);
        postOrderTraversalRecursive(root.right);
        System.out.print(root.value + " ");
    }

    public static void main(String[] args) {
        StringTreeNode root = StringTreeNode.getTree();
        postOrderTraversalRecursive(root);
        System.out.println();
        postOrderTraversalIterative(root);
    }

    private static void postOrderTraversalIterative(StringTreeNode root) {
        Stack<StringTreeNode> stack1 = new Stack<>();
        stack1.push(root);
        Stack<StringTreeNode> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null)
                stack1.push(root.left);
            if (root.right != null)
                stack1.push(root.right);
        }

        while (!stack2.isEmpty()) {
            root = stack2.pop();
            System.out.print(root.value + " ");
        }

    }
}
