package com.example.main.json;

import org.junit.Test;

import java.lang.reflect.Field;

public class SimpleJsonPrinter {

    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    @Test
    public void main() {
        Person person = new Person("张三", 18);
        System.out.println(toJson(person));
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }

        Class<?> clazz = obj.getClass(); // 获取目标对象的类对象

        // String
        if (clazz == String.class) {
            return "\"" + obj + "\"";
        }

        // 基本类型 & 包装类 直接打印
        if (clazz.isPrimitive() || Number.class.isAssignableFrom(clazz) || clazz == Boolean.class) {
            return obj.toString();
        }

        // 普通对象
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        Field[] fields = clazz.getDeclaredFields(); // 获取对象所有字段（不包括父类字段）
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true); // 破除 private 限制

            if (f.isSynthetic()) { // 跳过  synthetic 字段 如 this$0字段
                continue;
            }

            try {
                Object value = f.get(obj);
                sb.append("\"").append(f.getName()).append("\":");
                sb.append(toJson(value));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            if (i < fields.length - 1) {
                sb.append(",");
            }
        }

        sb.append("}");
        return sb.toString();
    }

}