package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    // 3 -1 -5 : 1 = a1
    // 3 -1 -5 -9 : 2*a1 +1- a1 = 3 =a2
    // 3 -1 -5 -9 -13 : 2*a2 +1 -a1 = 6
    // 3 -1 -5 -9 -13 -17: 2*a3 +1 -a2

    public static void main(String[] args) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("apple", 5);
        hashMap.put("banana", 3);
        hashMap.get("apple");             // 获取值
        hashMap.getOrDefault("orange", 0); // 获取值或默认值
        hashMap.containsKey("apple");     // 判断是否包含键
        hashMap.containsValue(5);         // 判断是否包含值
        hashMap.remove("apple");          // 删除键值对
        hashMap.size();                   // 获取大小
        hashMap.isEmpty();                // 判断是否为空
        hashMap.keySet();
        hashMap.values();

        // Java 8 新方法
        hashMap.putIfAbsent("grape", 8);  // 如果不存在则添加
        hashMap.merge("apple", 2, Integer::sum); // 合并值
        hashMap.compute("banana", (k, v) -> v * 2); // 计算新值
        hashMap.computeIfAbsent("orange", k -> 0); // 如果不存在则计算新值

        // 比较 put、putIfAbsent、computeIfAbsent
        Map<String, List<String>> map = new HashMap();
        List<String> list1 = map.putIfAbsent("234", new ArrayList<>()); // null 存在返回存在的value，不存在返回null，与 put()方法返回一致
        List<String> list2 = map.computeIfAbsent("234", v -> new ArrayList<>());  // [] 存在返回存在的value，不存在返回自己计算的属性

        int i = Main.fun1(new int[]{3,- 1,- 5,- 9,- 13,- 17});
        System.out.println(i);
    }


    public static int fun1(int[] arr){
        if(arr.length<3){
            return 0;
        }

        int sum = 0;
        int count = 1;
        int d = arr[0]-arr[1];
        for(int i=0;i<arr.length-1;i++){
            if(d == arr[i]-arr[i+1]){
                count++;
            }else {
                d = arr[i]-arr[i+1];
                if (count>=3){
                    sum += comtpute(count);
                }
                count=0;
            }
        }
        if (count>=3){
            sum += comtpute(count);
        }
        return sum;
    }

    public static int comtpute(int len){

        if(len==3){
            return 1;
        }

        if (len==4){
            return 3;
        }
        int count = 2*comtpute(len-1)+1 - comtpute(len-2);
        return count;
    }



    // 题二
    public static boolean fun2(TreeNode tree1,TreeNode tree2){
        if(tree1==null && tree2==null){
            return true;
        }

        if(tree1== null || tree2==null){
            return false;
        }

        if(tree1.val != tree2.val){
            return false;
        }
        boolean left = fun2(tree1.left,tree2.left);
        boolean right = fun2(tree1.right,tree2.right);

        return left && right;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}