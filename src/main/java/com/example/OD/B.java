package com.example.OD;

import java.util.*;

public class B {

    public static void main(String[] args) {
        B b = new B();
        String[] strings = b.format_datelist(new String[] {"2002-2-2", "2002-02-00"});
        System.out.println(Arrays.toString(strings));
        String s= "2";
    }

    public String[] format_datelist(String[] inputs) {
        // write code here
        List<int[]> list = new ArrayList<int[]>();
        Set<String> hash = new HashSet<>();
        for (String s : inputs) {
            if (!s.matches("[0-9/-]*")) {
                continue;
            }
            String[] split = s.split("/");
            if (split.length != 3) {
                split = s.split("-");
            }

            if (split.length != 3) {
                continue;
            }

            int year;
            int month;
            int day;
            try {
                year = Integer.parseInt(split[0]);
                month = Integer.parseInt(split[1]);
                day = Integer.parseInt(split[2]);
            } catch (Exception e) {
                continue;
            }
            String ket = year + "-" + month + "-" + day;
            if (hash.contains(ket) || !check(year, month, day)) {
                continue;
            }
            hash.add(ket);
            list.add(new int[] {year, month, day});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                }
                return 0;
            }
        });

        if (list.size() == 0) {
            return new String[] {"NULL"};
        }

        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int[] date = list.get(i);
            String month = date[1] < 9 ? "0" + date[1] : date[1] + "";
            String day = date[2] < 9 ? "0" + date[2] : date[2] + "";
            res[i] = date[0] + "-" + month + "-" + day;
        }

        return res;
    }

    public boolean check(int year, int month, int day) {
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year < 1000 || year > 2100) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        if (day < 1 || day > 31) {
            return false;
        }

        // 闰年
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            days[1] = 29;
        }

        return day <= days[month - 1];
    }
}