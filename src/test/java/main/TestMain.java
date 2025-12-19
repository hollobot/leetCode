package main;

import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(a)); // 直接打印数组
        System.out.println(Math.round(-1.7)); // 四舍五入
        System.out.println(Math.ceil(-1.7)); // 向上取整
        System.out.println(Math.floor(-1.1)); // 向下取整
    }
}
