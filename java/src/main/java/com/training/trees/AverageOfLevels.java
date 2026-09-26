package com.training.trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 637. Average of Levels in Binary Tree
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
* */
public class AverageOfLevels {

    public static void main(String[] args) {
        TreeNode node = TreeNode.tree1();
        System.out.println(averageOfLevels(node));
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        List<Double> levelsAverage = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
            double avg = (double) sum / size;
            levelsAverage.add(avg);
        }
        return levelsAverage;
    }
}
