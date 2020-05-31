package com.lasam.demo.leetcode;

/**
 * @author liuhao
 * @date 2020/5/31 00:42
 */
public class P101 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }

        //step1: l next left r next right
        if (!isSymmetric(l.left, r.right)) {
            return false;
        }

        //step2: l next right r next left
        if (!isSymmetric(l.right, r.left)) {
            return false;
        }
        return true;
    }


}
