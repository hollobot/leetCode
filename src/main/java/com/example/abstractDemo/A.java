package com.example.abstractDemo;

public interface A {

    public static final String a = "";

    public String fun01();

    default String fun02(){
        return null;
    }

    public static String fun04(){
        return null;
    }
}
