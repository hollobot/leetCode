package com.example.LeetCode75.栈;

import java.util.Stack;

public class 小行星碰撞 {

    public static void main(String[] args) {
        asteroidCollision(new int[] {3, 5, -6, 2, -1, 4});
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            }
            int peek = stack.peek();
            // 同号
            if (peek * asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }

            int num = asteroids[i];
            if (num > 0) {
                stack.push(num);
                continue;
            }

            if (Math.abs(peek) < Math.abs(num)) {
                stack.pop();
                i--;
                continue;
            }

            if (Math.abs(peek) == Math.abs(num)) {
                stack.pop();
            }

        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
