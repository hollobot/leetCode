package com.example.图的广度优先搜索;

import java.util.Arrays;

public class 蛇梯棋 {

    private int[] memo;
    private int[][] board;
    private boolean[] vis;
    private int n;
    private int maxIndex;

    private int tem = Integer.MAX_VALUE / 2;

    public int snakesAndLadders(int[][] board) {
        this.board = board;
        this.n = board.length;
        this.maxIndex = n * n;
        this.vis = new boolean[maxIndex + 1];
        memo = new int[maxIndex + 1];
        Arrays.fill(memo, -1);
        return dfs(1, 0);
    }

    public int dfs(int index, int count) {

        if (index > maxIndex) {
            return tem;
        }

        if (index == maxIndex) {
            vis[index] = false;
            return count;
        }

        if (vis[index]) {
            vis[index] = false;
            return tem;
        }

        vis[index] = true;

        int[] index1 = getIndex(index);
        int i = index1[0], j = index1[1];
        if (board[i][j] != -1) {
            index = board[i][j];
        }

        if (count >= 6) {
            vis[index] = false;
            return tem;
        }

        if (memo[index] != -1) {
            return count + memo[index];
        }
        int min = Integer.MAX_VALUE;
        min = Math.min(min, dfs(index + 1, count + 1));
        min = Math.min(min, dfs(index + 2, count + 1));
        min = Math.min(min, dfs(index + 3, count + 1));
        min = Math.min(min, dfs(index + 4, count + 1));
        min = Math.min(min, dfs(index + 5, count + 1));
        min = Math.min(min, dfs(index + 6, count + 1));
        vis[index] = false;
        return memo[index] = min;
    }

    public int[] getIndex(int index) {
        int row = (index - 1) / n;
        int col = (index - 1) % n;
        int i = n - 1 - row;
        return new int[] {i, (i & 1) == 0 ? n - 1 - col : col};
    }

    public static void main(String[] args) {
        int[][] board =
            {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}};

        蛇梯棋 蛇梯棋 = new 蛇梯棋();
        int i = 蛇梯棋.snakesAndLadders(board);
        System.out.println(i);
    }
}
