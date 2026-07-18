package com.example.LeetCode75.回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III {

    public static void main(String[] args) {
        new 组合总和III().combinationSum3(3, 7);
    }

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList();
        dfs(k, n, new ArrayList<>());
        return res;
    }

    public void dfs(int k, int n, List<Integer> list) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList(list));
            return;
        }

        if (n <= 0 || k <= 0) {
            return;
        }
        int size = list.size();
        Integer i1 = 0;
        if (size != 0) {
            i1 = list.get(size - 1);
        }
        for (int i = i1 + 1; i <= 9; i++) {
            list.add(i);
            dfs(k - 1, n - i, list);
            list.remove(list.size() - 1);
        }
    }
}
