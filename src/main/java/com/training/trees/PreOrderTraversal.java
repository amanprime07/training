package com.training.trees;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Root->Left->Right
 *
 * */
public class PreOrderTraversal {


    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        TreeNode node = fromArray(arr);
        System.out.println(preOrder(node));
    }

    private static TreeNode fromArray(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            if (hasLeftChild(i, arr)) {
                root.left = new TreeNode(arr[leftChildIdx(i)]);
            }
            if (hasRightChild(i, arr)) {
                root.right = new TreeNode(arr[rightChildIdx(i)]);
            }
        }
        return root;
    }

    private static boolean hasLeftChild(int idx, int[] arr) {
        return leftChildIdx(idx) < arr.length;
    }

    private static boolean hasRightChild(int idx, int[] arr) {
        return rightChildIdx(idx) < arr.length;
    }

    private static int leftChildIdx(int idx) {
        return idx + 1;
    }

    private static int rightChildIdx(int idx) {
        return idx + 2;
    }

    private static List<Integer> preOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrderTraversal(ans, root);
        return ans;
    }

    private static void preOrderTraversal(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preOrderTraversal(ans, root.left);
        preOrderTraversal(ans, root.right);
    }

    private static void preOrderTraversalRecursive(StringTreeNode root) {
        if (root == null)
            return;
        System.out.print(root.value + " ");
        preOrderTraversalRecursive(root.left);
        preOrderTraversalRecursive(root.right);
    }

    private static void preOrderTraversalIterative(StringTreeNode root) {
        Stack<StringTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.value + " ");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }


}
