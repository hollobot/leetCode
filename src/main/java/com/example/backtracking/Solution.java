package com.example.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 排列集合
        List<List<Integer>> path = new ArrayList();
        // 当前的排列动态对象
        List<Integer> cur = new ArrayList();
        int len = nums.length;
        // 判断是否使用
        boolean[] isUse = new boolean[len];

        // 递归方法
        dfs(path, cur, len, 0, isUse, nums);

        return path;
    }

    public void dfs(List<List<Integer>> path, List<Integer> cur, int len, int depth, boolean[] isUse, int[] nums) {
        // 递归深度等于长度代表递归到叶子节点了，代表已经排序好了。
        if (depth == len) {
            path.add(new ArrayList(cur)); // 复制需要遍历 O(n)
        }

        // 考虑每个位置所有元素的情况
        for (int i = 0; i < len; i++) {
            // 如果这个元素已经被使用哪个直接continue
            if (isUse[i]) {
                continue;
            }
            // 添加元素
            cur.add(nums[i]);
            isUse[i] = true;
            // 递归下一个位置
            dfs(path, cur, len, depth + 1, isUse, nums);
            // 回溯撤回操作
            cur.remove(cur.size() - 1);
            isUse[i] = false;
        }
    }


    Map<Character, String> map = new HashMap();
    List<String> res = new ArrayList();
    StringBuffer str = new StringBuffer();

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0) {
            return res;
        }

        dfs(len, 0, 0, digits);
        return res;
    }

    public void dfs(int len, int first, int index, String digits) {
        if (len == index) {
            res.add(str.toString());
            return;
        }

        String target = map.get(digits.charAt(index));

        for (int i = first; i < target.length(); i++) {
            str.append(target.charAt(i));
            dfs(len, 0, index + 1, digits);
            str.deleteCharAt(str.length() - 1);
        }
    }




}