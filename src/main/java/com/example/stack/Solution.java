package com.example.stack;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        String[] target = {"4", "13", "5", "/", "+"};
        evalRPN(target);
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList();
        List<String> temp = new ArrayList();

        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (i == target[index]) {
                index++;
                list.addAll(temp);
                temp.remove(1);
            } else {
                temp.add("Pop");
            }
            list.add("Push");
        }
        return list;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            switch (str) {
                case "*": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                }
                case "/": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                }
                case "+": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                }
                case "-": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Map<Integer, Integer> map = new HashMap();
        Stack<Map.Entry<Integer, Integer>> stack = new Stack();
        for (String log : logs) {
            String[] split = log.split(":");

        }
        return null;
    }
}