package com.example.str;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        repeatedStringMatch("abcd","cdabcdab");
    }


    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder r = new StringBuilder();
        int len = s.length();
        int count = 0;
        int step = 'a' - 'A';
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') {
                continue;
            }

            if (c >= 'a') {
                r.insert(0, (char)(c - step));
            } else {
                r.insert(0, c);
            }

            if (++count == k) {
                r.insert(0, '-');
                count = 0;
            }
        }

        String str = r.toString();
        if (!"".equals(str) && str.substring(0, 1).equals("-")) {
            return str.substring(1);
        }

        return str;
    }

    public static String maskPII(String s) {
        int index = s.indexOf('@');
        int step = 'a' - 'A';

        // 邮箱
        if (index != -1) {
            String substring = s.substring(index - 1);
            String lowerCase = substring.toLowerCase();
            char firstChar = s.charAt(0);
            if (firstChar >= 'A' && firstChar <= 'Z') {
                firstChar += step;
            }
            return firstChar + "*****" + lowerCase;
        }

        // 手机号
        String str = s.replaceAll("[+\\-()\\s]", "");
        int len = str.length();
        String subfix = str.substring(len - 4, len);
        switch (len){
            case 10:
                return "***-***-"+subfix;
            case 11:
                return "+*-***-***-"+subfix;
            case 12:
                return "+**-***-***-"+subfix;
            case 13:
                return "+***-***-***-"+subfix;
            default: return "";
        }
    }


    public static boolean rotateString(String s, String goal) {
        char firstchar = goal.charAt(0);
        int len = s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)==firstchar && fun(s,goal,i)){
                return true;
            }
        }

        return false;
    }

    public static boolean fun(String s, String goal,int index){
        int len = s.length();
        int size = s.length();
        int x = Math.min(len,index+1);
        for(int i=1;i<size;i++){
            if(x==len){
                x=0;
            }
            if(s.charAt(x)!=goal.charAt(i)){
                return false;
            }
            x++;
        }

        return true;
    }


    public static int repeatedStringMatch(String a, String b) {
        if ("".equals(b)) {
            return 0;
        }

        if (a.equals(b)) {
            return 1;
        }

        StringBuilder str = new StringBuilder(a);
        int len = str.length();
        int size = b.length();
        char c = b.charAt(0);
        int count = 1;
        while (size * 2 >= len) {
            if (len < size) {
                str.append(a);
                len = str.length();
                count++;
                continue;
            }
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == c && b.equals(str.substring(i, Math.min(i + size, len)))) {
                    return count;
                }
            }
            str.append(a);
            len = str.length();
            count++;
        }

        return -1;
    }
}

