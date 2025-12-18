package com.example.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 */
public class CoinChange {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        CoinChange coinChange = new CoinChange();
        int[] coins = {2};
        coinChange.coinChange(coins,11);
    }

    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        return dfs(coins,len,amount);
    }

    public int dfs(int[] coins,int len, int amount){
        if(amount<=0){
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for(int i=0;i<len;i++){
            min = Math.min(min,dfs(coins,len,amount-coins[i])+1);
        }
        return min;
    }
}
