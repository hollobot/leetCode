package com.example.test;

public interface MyInterface {

    /** 无构造方法 */

    public static final int a = 10;

    int b = 10;

    static void show(){
        System.out.println("hello");
    }

    default void print(){
        System.out.println("default print");
    }

    public static void display(){
        System.out.println("static display");
    };

    public static void main(String[] args) {
        MyInterface.show();
        System.out.println(MyInterface.b);
    }
}
