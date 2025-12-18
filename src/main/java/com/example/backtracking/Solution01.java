package com.example.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution01 {

    public static void main(String[] args) {
        new Solution01().generateParenthesis(3);
    }

    Stack<String> stack = new Stack();
    List<String> res = new ArrayList();
    StringBuffer str = new StringBuffer();

    public List<String> generateParenthesis(int n) {
        dfs(0, 2 * n);
        return res;
    }

    public void dfs(int index, int n) {
        if (index == n) {
            if (stack.empty()) {
                res.add(new String(str));
            }
            return;
        }


        stack.push("(");
        str.append("(");
        dfs(index + 1, n);
        stack.pop();
        str.deleteCharAt(str.length() - 1);

        if (stack.empty()) {
            return;
        }
        str.append(")");
        String top = stack.pop();  // 弹出匹配的左括号
        dfs(index + 1, n);
        stack.push(top);
        str.deleteCharAt(str.length() - 1);
    }
}
