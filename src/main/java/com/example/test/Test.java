package com.example.test;

import java.util.Arrays;

public class Test {
    private static final  String s = "咱们面向全国招聘，消息一直都很多，可能没办法快速回复；因为简历初筛已经通过了，如果以上沟通内容没有问题的话，可以直接添加我的企微沟通更高效哦~\n企微详细沟通后我们也会安排正式面试哈\n" +
        "请务必备注【姓名+线上全职运营】，否则无法及时通过哈！\n" +
        "如果有其他你非常在意的问题，当然也可以直接沟通哈，解决后再自行添加~";
    public static void main(String[] args) {
        split(s);

    }

    public static void split(String s){
        String[] split = s.split("\n");
        System.out.println(Arrays.asList(split));
    }

    public int max(int ...a){
        int max = 0;
        for (int i : a){
            max = Math.max(max, i);
        }
        return max;
    }
}
