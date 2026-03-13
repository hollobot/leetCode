package com.example.bit.简单;

public class 汉明距离 {

    public static void main(String[] args) {
        //        hammingDistance(93,73);
        System.out.println((5 ^ 2) & 1);
    }

    public static int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if (((x ^ y) & 1) == 1) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }

        return count;
    }
}
