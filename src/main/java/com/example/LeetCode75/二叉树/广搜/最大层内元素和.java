package com.example.LeetCode75.二叉树.广搜;

import com.example.LeetCode75.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 最大层内元素和 {

    public int maxLevelSum(TreeNode root) {
        int[] max = new int[] {1, root.val};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()) {
            index++;
            int size = queue.size();
            Queue<TreeNode> temp = new LinkedList<>();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            if (sum > max[1]) {
                max[0] = index;
                max[1] = sum;
            }
            queue = temp;
        }
        return max[0];
    }

}
