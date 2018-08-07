package com.training.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

    private static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.value + " ");
            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        System.out.println("TOP TO BOTTOM: ");
        levelOrderTraversal(root);
        System.out.println();
        System.out.println("BOTTOM TO TOP: ");
        levelOrderTraversalReverse(root);
    }

    private static void levelOrderTraversalReverse(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            stack.push(root);
            if(root.right!=null)
                queue.add(root.right);
            if(root.left!=null)
                queue.add(root.left);
        }

        while (!stack.isEmpty()){
            root = stack.pop();
            System.out.print(root.value + " ");
        }
    }
}
