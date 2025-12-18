package com.example.scanner;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // 读取整行输入
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken(); // 读取第一个数据
        System.out.println(s);
        System.out.println(s1);
    }
}
