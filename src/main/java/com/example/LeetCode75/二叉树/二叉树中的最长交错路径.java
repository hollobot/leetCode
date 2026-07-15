package com.example.LeetCode75.二叉树;

public class 二叉树中的最长交错路径 {
    private int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, 0, true);
        dfs(root.right, 0, false);
        return max;
    }

    public void dfs(TreeNode root, int count, boolean isLeft) {
        if (root == null) {
            return;
        }

        count++;
        max = Math.max(max, count);

        dfs(root.left, isLeft ? 0 : count, true);
        dfs(root.right, isLeft ? count : 0, false);
    }
}
