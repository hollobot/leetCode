package com.example.dp;

public class Main {

    public static void main(String[] args) {
        longestPalindrome("babad");
    }

    /**
     * 给你一个字符串 s，找到 s 中最长的 回文 子串。
     *
     *
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     */

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // 以单个字符为中心扩展(处理奇数长度回文)
            int len1 = expandAroundCenter(s, i, i);
            // 以两个字符之间为中心扩展(处理偶数长度回文)
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            // 更新最长回文子串的起始和结束位置
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // 从中心向两边扩展,返回回文长度
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 返回回文长度
        return right - left - 1;
    }
}
