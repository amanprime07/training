package com.training.trees;


public class TreeNode {
    TreeNode left;
    TreeNode right;
    String value;

    public TreeNode(String value) {
        this.value = value;
    }

    /*
            A
           / \
          B   C
         / \
        D  E
           /
          F
     */

    public static TreeNode getTree() {
        TreeNode root = new TreeNode("A");
        TreeNode left1 = new TreeNode("B");
        root.left = left1;
        root.right = new TreeNode("C");
        left1.left = new TreeNode("D");
        TreeNode right2 = new TreeNode("E");
        left1.right = right2;
        right2.left = new TreeNode("F");
        return root;
    }


    /*       2
          /    \
        7       5
        \       \
        6       9
       / \     /
      1  11   4
*/
    public static TreeNode getTree1() {
        TreeNode root = new TreeNode("2");
        root.left = new TreeNode("7");
        root.right = new TreeNode("5");
        root.left.right = new TreeNode("6");
        root.left.right.left = new TreeNode("1");
        root.left.right.right = new TreeNode("11");
        root.right.right = new TreeNode("9");
        root.right.right.left = new TreeNode("4");
        return root;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        if (left != null ? !left.equals(treeNode.left) : treeNode.left != null) return false;
        if (right != null ? !right.equals(treeNode.right) : treeNode.right != null) return false;
        return value.equals(treeNode.value);
    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (right != null ? right.hashCode() : 0);
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", value='" + value + '\'' +
                '}';
    }
}
