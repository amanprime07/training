package com.training.trees;

import java.util.Stack;

public class IdenticalTreesVerification {

    private static boolean verifiyIdenticalRecusrsion(StringTreeNode root1, StringTreeNode root2) {
        if (root1 != null && root2 != null) {
            verifiyIdenticalRecusrsion(root1.left, root2.left);
            verifiyIdenticalRecusrsion(root1.right, root2.right);
            return root1.equals(root2);
        }
        return false;
    }

    public static void main(String[] args) {
        StringTreeNode root1 = StringTreeNode.getTree();
        StringTreeNode root2 = StringTreeNode.getTree();
        StringTreeNode temp = new StringTreeNode("G");
        root2.right.right = temp;
        System.out.println(verifiyIdenticalRecusrsion(root1, root2));
        System.out.println(verifyIdenticalTreeIterative(root1, root2));
    }

    private static boolean verifyIdenticalTreeIterative(StringTreeNode root1, StringTreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        Stack<StringTreeNode> stack1 = new Stack<>();
        Stack<StringTreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            root1 = stack1.pop();
            root2 = stack2.pop();
            if (root1.equals(root2)) {
                if (root1.left != null && root2.left != null) {
                    stack1.push(root1.left);
                    stack2.push(root2.left);
                }
                if (root1.right != null && root2.right != null) {
                    stack1.push(root1.right);
                    stack2.push(root2.right);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
