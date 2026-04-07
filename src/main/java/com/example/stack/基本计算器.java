package com.example.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 基本计算器 {

    public static void main(String[] args) {
        int num = calculate("-2+3+3");
        System.out.println(num);
    }

    public static int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        int sum = 0;
        int sign = 1;
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            switch (c) {
                case '-':
                    sign = -stack.peek();
                    i++;
                    break;
                case '+':
                    sign = stack.peek();
                    i++;
                    break;
                case '(':
                    stack.push(sign);
                    i++;
                    break;
                case ')':
                    stack.pop();
                    i++;
                    break;
                case ' ':
                    i++;
                    break;
                default:
                    int num = c - '0';
                    i++;
                    while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    sum += sign * num;
                    sign = 1;
            }
        }
        return sum;
    }

}
