package com.training.trees;

import java.util.Stack;

public class ValidateBST {

    public static void main(String[] args) {
        TreeNode root = TreeNode.bst1();
        System.out.println(isValid(root));
        System.out.println(isValidStack(root));
        root.left.left.left = new TreeNode(14);
        System.out.println(isValid(root));
        System.out.println(isValidStack(root));
    }

    private static boolean isValid(TreeNode node) {
        return isValid(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValid(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val < minValue || root.val > maxValue) {
            return false;
        }
        return isValid(root.left, minValue, root.val) && isValid(root.right, root.val, maxValue);
    }

    private static boolean isValidStack(TreeNode root) {
        Stack<Triplet> stack = new Stack<>();
        stack.push(new Triplet(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while (!stack.isEmpty()) {
            Triplet t = stack.pop();
            TreeNode node = t.node;
            int minValue = t.minValue;
            int maxValue = t.maxValue;
            if (node.val < minValue || node.val > maxValue) {
                return false;
            }
            if (node.right != null) {
                stack.push(new Triplet(node.right, node.val, maxValue));
            }
            if (node.left != null) {
                stack.push(new Triplet(node.left, minValue, node.val));
            }
        }
        return true;
    }

    private static class Triplet {
        TreeNode node;
        int minValue;
        int maxValue;

        public Triplet(TreeNode node, int minValue, int maxValue) {
            this.node = node;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }


}
