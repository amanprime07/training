package com.training.trees;

import java.util.Stack;

public class CountHalfNodesInTree {

    private static int countHalfNodesRecursive(StringTreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        if ((root.left != null && root.right == null) || (root.right != null && root.left == null))
            count++;
        count = count + countHalfNodesRecursive(root.left) + countHalfNodesRecursive(root.right);
        return count;
    }

    public static void main(String[] args) {
        StringTreeNode root = StringTreeNode.getTree1();
        System.out.println(countHalfNodesRecursive(root));
        System.out.println(countHalfNodesIterative(root));
    }

    private static int countHalfNodesIterative(StringTreeNode root) {
        int count = 0;
        if (root == null)
            return count;
        Stack<StringTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if ((root.left != null && root.right == null) || (root.right != null && root.left == null))
                count++;
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        return count;
    }
}
