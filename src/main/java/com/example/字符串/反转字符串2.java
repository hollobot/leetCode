package com.example.字符串;

public class 反转字符串2 {

    public String reverseStr(String s, int k) {
        StringBuilder r = new StringBuilder();
        int len = s.length();
        int l = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            count++;
            if (count == 2 * k) {
                fun(r, s.substring(l, l + k));
                r.append(s.substring(l + k, i + 1));
                l = i + 1;
                count = 0;
            }
        }

        if (count < k) {
            r.append(s.substring(l, len));
        } else if (count < 2 * k) {
            fun(r, s.substring(l, l + k));
            r.append(s.substring(l + k, len));
        }

        return r.toString();
    }

    public void fun(StringBuilder r, String s) {
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            r.append(s.charAt(i));
        }
    }
}
