package com.example.LeetCode75.动态规划;

import java.util.Arrays;

public class 买卖股票的最佳时机含手续费 {

    private int[] prices;
    private int fee;
    private int[][] memo;

    public int maxProfit(int[] prices, int fee) {
        this.fee = fee;
        this.prices = prices;
        memo = new int[prices.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, prices.length, 0);
    }

    public int dfs(int index, int len, int isUse) {
        if (index >= len) {
            return 0;
        }

        if (memo[index][isUse] != -1) {
            return memo[index][isUse];
        }

        int sum = 0;
        if (isUse == 1) {
            // 卖
            sum = prices[index] - fee + dfs(index + 1, len, 0);
        } else {
            // 买
            sum = dfs(index + 1, len, 1) - prices[index];
        }

        return memo[index][isUse] = Math.max(dfs(index + 1, len, isUse), sum);
    }
}
