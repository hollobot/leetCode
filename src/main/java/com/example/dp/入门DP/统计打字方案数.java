package com.example.dp.入门DP;

import java.util.Arrays;

public class 统计打字方案数 {

    public static void main(String[] args) {
        countHousePlacements(1000);
    }

    public static final int b = (int)Math.pow(10, 9) + 7;

    public static int countHousePlacements(int n) {
        int d = 2, p = 3;
        if (n == 1) {
            return d * d;
        }

        if (n == 2) {
            return p * p;
        }

        for (int i = 3; i <= n; i++) {
            int tem = (d + p) % b;
            d = p;
            p = tem;
        }

        return (int)((long)p * p % b);
    }

    public static int countTexts(String pressedKeys) {
        int len = pressedKeys.length();
        int[] group = new int[] {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        int[][] memo = new int[5][len + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        long sum = 1;
        int count = 1;
        for (int i = 1; i <= len; i++) {
            char c = pressedKeys.charAt(i - 1);
            if (i == len || pressedKeys.charAt(i) != c) {
                sum = (sum * dfs(count, group[c - '0'], memo)) % b;
                count = 1;
            } else {
                count++;
            }
        }

        return (int)sum;
    }

    public static int dfs(int n, int step, int[][] memo) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (memo[step][n] != -1) {
            return memo[step][n];
        }

        int sum = 0;
        for (int i = 1; i <= step; i++) {
            int index = n - i;
            if (index < 0) {
                break;
            }
            memo[step][index] = dfs(index, step, memo) % b;
            sum = (sum + memo[step][index]) % b;
        }
        return memo[step][n] = sum;
    }
}
