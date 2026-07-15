package com.example.LeetCode75.动态规划;

public class 第N个泰波那契数 {

    public int tribonacci(int n) {
        if (n < 3) {
            return (n + 1) / 2;
        }
        int a1 = 0, a2 = 1, a3 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = a1 + a2 + a3;
            a1 = a2;
            a2 = a3;
            a3 = temp;
        }
        return a3;
    }
}
