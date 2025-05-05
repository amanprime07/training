package com.training.trees;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNodeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.tree1();
        System.out.println(deepestNodeDFS(root));
        System.out.println(deepestNodeBFS(root));
    }

    private static TreeNode deepestNodeDFS(TreeNode root) {
        int[] maxHeight = {0};
        TreeNode[] dn = new TreeNode[]{null};
        deepestNodeDFS(root, 0, maxHeight, dn);
        return dn[0];
    }

    private static void deepestNodeDFS(TreeNode root, int height, int[] max, TreeNode[] dn) {
        if (root == null) {
            return;
        }
        if (height >= max[0]) {
            dn[0] = root;
            max[0] = height;
        }
        deepestNodeDFS(root.left, height + 1, max, dn);
        deepestNodeDFS(root.right, height + 1, max, dn);
    }

    private static TreeNode deepestNodeBFS(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode deepestNode = root;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            deepestNode = node;
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return deepestNode;
    }


}
