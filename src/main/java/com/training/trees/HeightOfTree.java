package com.training.trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {
    private static int computeHeightOfTreeIterative(StringTreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<StringTreeNode> queue = new LinkedList<>();
        int height = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            while (nodeCount > 0) {
                root = queue.poll();
                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
                nodeCount--;
            }
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        StringTreeNode root = new StringTreeNode("1");
        root.left = new StringTreeNode("2");
        root.right = new StringTreeNode("3");
        root.left.left = new StringTreeNode("4");
        root.left.right = new StringTreeNode("5");
        root.right.right = new StringTreeNode("6");
        StringTreeNode root1 = StringTreeNode.getTree();
        System.out.println(computeHeightOfTreeIterative(root1));
        System.out.println(computeHeightOfTreeRecursive(root1));
        System.out.println(depthOfTree(root1));
    }

    private static int computeHeightOfTreeRecursive(StringTreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(computeHeightOfTreeRecursive(root.left), computeHeightOfTreeRecursive(root.right));
    }

    private static int depthOfTree(StringTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = depthOfTree(root.left);
        int rightHeight = depthOfTree(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
