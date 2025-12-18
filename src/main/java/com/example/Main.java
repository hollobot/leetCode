package com.example;

import java.util.HashMap;

public class Main {
    // 3 -1 -5 : 1 = a1
    // 3 -1 -5 -9 : 2*a1 +1- a1 = 3 =a2
    // 3 -1 -5 -9 -13 : 2*a2 +1 -a1 = 6
    // 3 -1 -5 -9 -13 -17: 2*a3 +1 -a2

    public static void main(String[] args) {

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