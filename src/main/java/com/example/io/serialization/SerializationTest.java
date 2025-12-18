package com.example.io.serialization;

import com.example.io.Good;

import java.io.*;

public class SerializationTest {

    public static void main(String[] args) {
        Good good = new Good("Laptop", 1200.0, "隐藏字段");

        System.out.println(new Good());

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(".\\good.ser"));
            oos.writeObject(good);
            System.out.println("对象序列化成功");

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(".\\good.ser"));
            Good o = (Good)ois.readObject();
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
