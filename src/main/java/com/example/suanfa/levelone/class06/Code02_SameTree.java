package com.example.suanfa.levelone.class06;

/**
 * // 测试链接：https://leetcode.com/problems/same-tree
 * 递归序题目:
 *        判断两个树的结构是否完全相等
 * @author: Elliot Ji
 * @createDate: 2022-05-28
 **/
public class Code02_SameTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        // 都不为空
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
