package com.training.trees;

import java.util.ArrayList;
import java.util.List;

/*
* 572. Subtree of Another Tree
    Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
    A subtree of a binary tree `tree` is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
* */
public class SubTreeAnotherTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.tree1();
        TreeNode subRoot = TreeNode.tree1();
        System.out.println(isSubTree(root, subRoot.left));
        System.out.println("isSubTreeOptimized " + isSubTreeOptimized(root, subRoot.left));
        subRoot.left.left = new TreeNode(12);
        System.out.println(isSubTree(root, subRoot.left));
        System.out.println("isSubTreeOptimized " + isSubTreeOptimized(root, subRoot.left));
    }

    /*
     * Time Complexity: O(m*n) where m is # of nodes in root and n is # of nodes in subRoot.
     * Space Complexity: O(m)
     * */
    private static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (isSame(root, subRoot)) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (q == null || p == null || p.val != q.val) {
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    private static boolean isSubTreeOptimized(TreeNode root, TreeNode subRoot) {
        int subTreeHeight = treeHeight(subRoot);
        List<TreeNode> nodes = new ArrayList<>();
        subTreesWithHeight(root, nodes, subTreeHeight);

        for (TreeNode node : nodes) {
            if (isSame(node, subRoot)) {
                return true;
            }
        }
        return false;

    }

    private static void subTreesWithHeight(TreeNode root, List<TreeNode> nodes, int h) {
        if (root == null) {
            return;
        }
        int height = treeHeight(root);
        if (height < h) {
            return;
        }
        if (height == h) {
            nodes.add(root);
        }
        subTreesWithHeight(root.left, nodes, h);
        subTreesWithHeight(root.right, nodes, h);


    }

    private static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
