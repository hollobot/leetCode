package com.example.OD;

import java.util.ArrayList;

public class A {

    public static void main(String[] args) {
        A a = new A();
        a.GetNaughtyStudentID(10, new int[] {9, 2, 3, 5, 6, 7});
    }

    public ArrayList<Integer> GetNaughtyStudentID(int studentNum, int[] studentIDList) {
        // write code here
        int[] ans = new int[studentNum + 1];
        int len = studentIDList.length;
        for (int i = 0; i < len; i++) {
            ans[studentIDList[i]] = 1;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= studentNum; i++) {
            if (ans[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }

}
