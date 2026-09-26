package com.striver79;

import com.training.trees.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumInBST {

    public static void main(String[] args) {
        TreeNode bst = TreeNode.bst1();
        System.out.println(findTarget(bst, 11));
        System.out.println(findTarget(bst, 10));
        System.out.println(findTarget(bst, 14));
    }

    private static boolean findTarget(TreeNode root, int target) {
        return findTarget(root, target, new HashSet<>());
    }

    private static boolean findTarget(TreeNode root, int target, Set<Integer> set) {
        if (root == null) {
            return false;
        }

        int diff = target - root.val;
        if (set.contains(diff)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, target, set) || findTarget(root.right, target, set);
    }
}
