package com.example.LeetCode75.位运算;

public class 或运算的最小翻转次数 {

    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (c != 0) {
            int t = c & 1;
            if (t == 1 && (a & 1) == 0 && (b & 1) == 0) {
                count++;
            } else if (t == 0) {
                if ((a & 1) == 1) {
                    count++;
                }

                if ((b & 1) == 1) {
                    count++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        while (a != 0 || b != 0) {
            if ((a & 1) == 1) {
                count++;
            }

            if ((b & 1) == 1) {
                count++;
            }

            a >>= 1;
            b >>= 1;
        }

        return count;
    }
}
