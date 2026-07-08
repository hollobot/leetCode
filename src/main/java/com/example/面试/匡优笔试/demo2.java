package com.example.面试.面试01;

public class demo2 {

    static volatile boolean stop = false;

    public static void main(String[] args) {
        //maxNumber为一个从传参获取的整型数，
        //要求实现startPrint方法，间隔1s，打印1到maxNumber，不能阻塞主线程
        startPrint(20);
        //stopTime为一个从传参获取的整型数,单位秒
        //要求实现stopPrint方法，一段时间后结束打印，不能阻塞主线程
        stopPrint(30);
    }

    public static void startPrint(int maxNumber) {
        new Thread(() -> {
            for (int i = 1; i <= maxNumber; i++) {
                if (stop) {
                    break;
                }
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public static void stopPrint(int stopTime) {
        new Thread(() -> {
            try {
                Thread.sleep(stopTime * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stop = true;
        }).start();
    }
}