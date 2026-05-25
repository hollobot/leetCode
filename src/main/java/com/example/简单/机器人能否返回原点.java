package com.example.简单;

public class 机器人能否返回原点 {

    public boolean judgeCircle(String moves) {
        int l = 0, u = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'L':
                    l++;
                    break;
                case 'R':
                    l--;
                    break;
                case 'U':
                    u++;
                    break;
                case 'D':
                    u--;
                    break;
            }
        }

        return l == 0 && u == 0;
    }
}
