package com.example.LeetCode75.二叉树.深搜;

import com.example.LeetCode75.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 叶子相似的树 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(list1, root1);
        dfs(list2, root2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void dfs(List<Integer> list, TreeNode root) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        if (root.left != null) {
            dfs(list, root.left);
        }

        if (root.right != null) {
            dfs(list, root.right);
        }
    }
}
