package com.example.tree;

import java.util.*;

public class 二叉树的锯齿形层序遍历 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode root1l = new TreeNode(2);
        TreeNode root1r = new TreeNode(3);
        root.left = root1l;
        root.right = root1r;
        root1l.left = new TreeNode(4);
        root1l.right = new TreeNode(5);


        zigzagLevelOrder(root);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList();
        Stack<TreeNode> stack = new Stack();
        queue.offer(root);
        stack.push(root);

        boolean flag = true;
        while (!queue.isEmpty()) {
            Queue<TreeNode> tempQ = new LinkedList();
            Stack<TreeNode> tempS = new Stack();
            List<Integer> list = new ArrayList();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                TreeNode stNode = stack.pop();
                if (flag) {
                    list.add(node.val);
                } else {
                    list.add(stNode.val);
                }
                if (node.left != null) {
                    tempQ.offer(node.left);
                    tempS.push(node.left);
                }

                if (node.right != null) {
                    tempQ.offer(node.right);
                    tempS.push(node.right);
                }
            }
            flag = !flag;
            res.add(list);
            queue = tempQ;
            stack = tempS;

        }

        return res;
    }
}


