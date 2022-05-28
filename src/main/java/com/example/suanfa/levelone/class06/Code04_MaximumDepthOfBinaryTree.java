package com.example.suanfa.levelone.class06;

/**
 * 测试链接：https://leetcode.com/problems/maximum-depth-of-binary-tree
 * 递归序: 返回一颗树的最大深度
 * @author: Elliot Ji
 * @createDate: 2022-05-28
 **/
public class Code04_MaximumDepthOfBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 以root为头的树，最大高度是多少返回！
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
