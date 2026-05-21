package com.example.数组;

import java.util.HashSet;
import java.util.Set;

public class 唯一摩尔斯密码词 {

    public static void main(String[] args) {
        String[] strings = {"gin", "zen", "gig", "msg"};
        new 唯一摩尔斯密码词().uniqueMorseRepresentations(strings);
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] arr =
            new String[] {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> hash = new HashSet();
        for (String s : words) {
            StringBuilder str = new StringBuilder();
            for (char c : s.toCharArray()) {
                str.append(arr[c - 'a']);
            }
            hash.add(str.toString());
        }

        return hash.size();
    }
}
