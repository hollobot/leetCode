package com.example.面试;

public class Demo01 {

    static class A{
        String name;

        public A(){}

        public void show(){
            System.out.println("this is" + this.name);
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.show();
    }
}
