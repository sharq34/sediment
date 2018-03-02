package com.marcojan.sediment.algorithm.leetcode;

public class Invert_Binary_Tree {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode interim;

        interim = root.left;
        root.left = root.right;
        root.right = interim;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
