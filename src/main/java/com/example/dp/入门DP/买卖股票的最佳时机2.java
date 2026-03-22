package com.example.dp.入门DP;

import java.util.Arrays;

public class 买卖股票的最佳时机2 {

    public static void main(String[] args) {

    }

    private int[][] memo;
    private int[] prices;

    public int maxProfit(int[] prices) {
        int len = prices.length;
        this.prices = prices;
        this.memo = new int[len][2];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return Math.max(dfs(0, 0), dfs(0, 1) - prices[0]);
    }

    public int dfs(int index, int type) {

        if (index >= prices.length) {
            return 0;
        }

        if (memo[index][type] != Integer.MIN_VALUE) {
            return memo[index][type];
        }

        if (type == 0) {
            return memo[index][type] = Math.max(dfs(index + 1, 0), -prices[index] + dfs(index + 1, 1));
        }

        return memo[index][type] = Math.max(prices[index] + dfs(index + 1, 0), dfs(index + 1, 1));
    }
}
