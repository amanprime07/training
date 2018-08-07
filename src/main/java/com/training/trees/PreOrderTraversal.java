package com.training.trees;


import java.util.Stack;

public class PreOrderTraversal {

    private static void preOrderTraversalRecursive(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.value + " ");
        preOrderTraversalRecursive(root.left);
        preOrderTraversalRecursive(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree1();
        preOrderTraversalRecursive(root);
        System.out.println();
        preOrderTraversalIterative(root);
    }

    private static void preOrderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.value + " ");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left!= null) {
                stack.push(root.left);
            }
        }
    }


}
