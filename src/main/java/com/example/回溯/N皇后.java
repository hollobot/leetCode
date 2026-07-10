package com.example.回溯;

public class N皇后 {

    public static void main(String[] args) {
        System.out.println(new N皇后().totalNQueens(4));
    }

    private int h;
    private int count = 0;

    public int totalNQueens(int n) {
        int[][] memo = new int[n][n];
        this.h = n;
        dfs(memo, 0);
        return count;
    }

    public void dfs(int[][] memo, int row) {
        if (row == h) {
            count++;
            return;
        }
        for (int i = 0; i < h; i++) {
            int[][] temp = copy(memo);
            if (!computer(temp, row, i)) {
                continue;
            }

            dfs(temp, row + 1);
            // 擦除
            clear(temp);
        }
    }

    public boolean computer(int[][] memo, int n, int m) {
        if (memo[n][m] == 1 || memo[n][m] == 2) {
            return false;
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                if (memo[i][j] == 2) {
                    memo[i][j] = 1;
                }else if (n == i || m == j || (i + j == n + m) || (n - m == i - j)) {
                    memo[i][j] = 2;
                }
            }
        }

        return true;
    }

    public void clear(int[][] memo) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                if (memo[i][j] == 2) {
                    memo[i][j] = 0;
                }
            }
        }
    }

    public int[][] copy(int[][] memo) {
        int[][] temp = new int[h][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                temp[i][j] = memo[i][j];
            }
        }

        return temp;
    }

}
