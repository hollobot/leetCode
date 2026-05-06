package com.example.数组;

public class 第三大的数 {

    private long one = (long)Integer.MIN_VALUE - 1;
    private long two = (long)Integer.MIN_VALUE - 1;
    private long three = (long)Integer.MIN_VALUE - 1;

    public static void main(String[] args) {
        new 第三大的数().thirdMax(new int[] {1, 2, 3});
    }

    public int thirdMax(int[] nums) {
        for (int num : nums) {
            fun(num);
        }
        return (int)(three == (long)Integer.MIN_VALUE - 1 ? one : three);
    }

    public void fun(int num) {

        if (num <= three) {
            return;
        }

        if (num > one) {
            three = two;
            two = one;
            one = num;
            return;
        }

        if (num == one) {
            return;
        }

        if (num > two) {
            three = two;
            two = num;
            return;
        }

        if (num == two) {
            return;
        }

        if (num > three) {
            three = num;
        }
    }
}
