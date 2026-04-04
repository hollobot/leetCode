package com.example.stack;

import java.util.Stack;

public class 简化路径 {

    public static void main(String[] args) {

    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] split = path.split("/");
        for (String s : split) {
            switch (s) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(s);
            }
        }

        String res = "";
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            res = "/" + pop + res;
        }

        return res.equals("") ? "/" : res;
    }
}
