package com.example.string;

import java.util.StringJoiner;

public class 反转字符串中的单词 {

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }


    public static String reverseWords1(String s) {
        String[] split = s.split(" +");

        StringJoiner stringJoiner = new StringJoiner(" ");

        for (int i = split.length-1; i >=0; i--) {
            stringJoiner.add(split[i]);
        }

        return stringJoiner.toString();
    }

    public static String reverseWords(String s) {
        String[] split = s.trim().split(" +");

        StringBuilder builder = new StringBuilder();
        builder.append(split[split.length-1]);
        for (int i = split.length-2; i >=0; i--) {
            builder.append(" "+split[i]);
        }

        return builder.toString();
    }
}
