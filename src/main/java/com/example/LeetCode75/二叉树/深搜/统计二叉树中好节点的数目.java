package com.example.LeetCode75.二叉树.深搜;

import com.example.LeetCode75.二叉树.TreeNode;

public class 统计二叉树中好节点的数目 {

    private int count;

    public int goodNodes(TreeNode root) {
        dfs(root, 0);
        return count;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            count++;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }

}
