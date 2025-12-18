package com.example.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 */
public class PalindromePartitioning {
    static List<List<String>>  res = new ArrayList();
    List<String> cur = new ArrayList();


    public static void main(String[] args) {
        new PalindromePartitioning().partition("aab");
        System.out.println(res);
    }



    public List<List<String>> partition(String s) {
        dfs(0, 1, s, s.length());
        return res;
    }

    public void dfs(int l, int r, String s, int len) {
        if (len == r-1 && cur.size()!=0) {
            res.add(new ArrayList(cur));
            return;
        }

        if(r<len){
            dfs(l, r + 1, s, len);
        }

        String str = s.substring(l, r);

        if (!check(str)) {
            return;
        }
        cur.add(str);
        dfs(r, r + 1, s, len);
        cur.remove(cur.size() - 1);
    }

    // 校验是否为回文字符串
    public boolean check(String s) {
        int len = s.length();
        if (len <= 1) {
            return true;
        }
        int l = 0, r = len - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
