package com.striver79;

import com.training.trees.TreeNode;

public class LowestCommonAncestorBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.tree1();
        System.out.println(lca(root, root.left.left, root.left.right).val);
        System.out.println(lca(root, root.left.left, root.right.right).val);
        System.out.println(lca(root, root.right.right, root.right.right).val);
    }


    /*
     *    1
     *   / \
     *  2   3
     *  /\  /\
     * 4 5  6 7
     */
    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


}
