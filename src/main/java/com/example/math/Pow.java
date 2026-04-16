package com.example.math;

public class Pow {

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }

    public static double myPow(double x, int N) {
        long n = N;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double ans = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }

        return ans;
    }
}
