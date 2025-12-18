package com.example.io;

import java.io.Serializable;

/**
 * 序列化对象
 */
public class Good implements Serializable {
    private String name;
    private double price;
    // 隐藏信息
    private transient String secretInfo;

    public Good() {
    }

    public Good(String name, double price, String secretInfo) {
        this.name = name;
        this.price = price;
        this.secretInfo = secretInfo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Good{" + "name='" + name + '\'' + ", price=" + price + ", secretInfo='" + secretInfo + '\'' + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSecretInfo() {
        return secretInfo;
    }

    public void setSecretInfo(String secretInfo) {
        this.secretInfo = secretInfo;
    }
}
