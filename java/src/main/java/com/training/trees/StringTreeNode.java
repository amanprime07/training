package com.training.trees;


import java.util.Objects;

public class StringTreeNode {
    StringTreeNode left;
    StringTreeNode right;
    String value;

    public StringTreeNode(String value) {
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

    public static StringTreeNode getTree() {
        StringTreeNode root = new StringTreeNode("A");
        StringTreeNode left1 = new StringTreeNode("B");
        root.left = left1;
        root.right = new StringTreeNode("C");
        left1.left = new StringTreeNode("D");
        StringTreeNode right2 = new StringTreeNode("E");
        left1.right = right2;
        right2.left = new StringTreeNode("F");
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
    public static StringTreeNode getTree1() {
        StringTreeNode root = new StringTreeNode("2");
        root.left = new StringTreeNode("7");
        root.right = new StringTreeNode("5");
        root.left.right = new StringTreeNode("6");
        root.left.right.left = new StringTreeNode("1");
        root.left.right.right = new StringTreeNode("11");
        root.right.right = new StringTreeNode("9");
        root.right.right.left = new StringTreeNode("4");
        return root;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringTreeNode stringTreeNode = (StringTreeNode) o;

        if (!Objects.equals(left, stringTreeNode.left)) return false;
        if (!Objects.equals(right, stringTreeNode.right)) return false;
        return value.equals(stringTreeNode.value);
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
