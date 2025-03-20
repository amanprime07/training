package com.training.trees;

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
        subRoot.left.left = new TreeNode(12);
        System.out.println(isSubTree(root, subRoot.left));
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
}
