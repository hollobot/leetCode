package com.example.数据结构;

import java.util.*;

public class O1时间插入删除和获取随机元素 {
    private List<Integer> list;
    private Map<Integer,Integer> map;
    private Random random;

    public static void main(String[] args) {

    }

    public O1时间插入删除和获取随机元素() {
        this.list = new ArrayList();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1); // 记录数组下标
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int index = map.get(val);
        int last = list.get(list.size()-1);
        list.set(index,last); // 更换位置
        map.put(last,index);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
