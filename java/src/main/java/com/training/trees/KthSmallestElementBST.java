package com.training.trees;

public class KthSmallestElementBST {

    public static void main(String[] args) {
        TreeNode root = TreeNode.bst1();
        System.out.println(kthSmallest(root, 5));
    }

    private static int kthSmallest(TreeNode root, int k) {
        int[] count = {k};
        int[] ans = {-1};
        kthSmallestElement(root, count, ans);
        return ans[0];
    }

    private static void kthSmallestElement(TreeNode root, int[] count, int[] ans) {
        if (root == null) {
            return;
        }

        kthSmallestElement(root.left, count, ans);
        count[0] = count[0] - 1;
        if (count[0] == 0) {
            ans[0] = root.val;
        }
        if (count[0] > 0) {
            kthSmallestElement(root.right, count, ans);

        }
    }
}
