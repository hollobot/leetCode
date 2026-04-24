package com.example.tree;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树 {
    private int[] inorder;
    private int[] postorder;
    private Map<Integer, Integer> map;

    public static void main(String[] args) {
        new 从中序与后序遍历序列构造二叉树().buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.map = new HashMap();
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }

        return dfs(0, len - 1, 0, len - 1);
    }

    public TreeNode dfs(int inL, int inR, int postL, int postR) {
        if (inL > inR) {
            return null;
        }

        int inVal = postorder[postR];
        int index = map.get(inVal);
        int l = index - inL;
        TreeNode root = new TreeNode(inVal);
        root.left = dfs(inL, index - 1, postL, postL + l - 1);
        root.right = dfs(index + 1, inR, postL + l, postR - 1);

        return root;
    }
}

