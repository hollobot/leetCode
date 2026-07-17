package com.example.LeetCode75.图.深度优先搜索;

import java.util.List;

public class 钥匙和房间 {

    private List<List<Integer>> rooms;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        int size = rooms.size();
        int[] memo = new int[size];
        dfs(memo, 0);

        for (int i = 0; i < size; i++) {
            if (memo[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public void dfs(int[] memo, int index) {
        if (memo[index] == 1) {
            return;
        }
        memo[index] = 1;
        List<Integer> list = rooms.get(index);
        for (int i = 0; i < list.size(); i++) {
            index = list.get(i);
            dfs(memo, index);
        }
    }
}
