package com.example.LeetCode75.二叉树.搜索树;

import com.example.LeetCode75.二叉树.TreeNode;

public class 删除二叉搜索树中的节点 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.right = root5;
        deleteNode(root, 3);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val != key) {
            root.left = deleteNode(root.left, key);
            root.right = deleteNode(root.right, key);
            return root;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        if (root.left != null && root.right != null) {
            TreeNode rootLeft = root.right;
            while (rootLeft.left != null) {
                rootLeft = rootLeft.left;
            }
            rootLeft.left = root.left;
            return root.right;
        }

        if (root.left == null) {
            return root.right;
        }

        if (root.right == null) {
            return root.left;
        }

        return root;
    }
}
