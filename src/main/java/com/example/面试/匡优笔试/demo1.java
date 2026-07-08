package com.example.面试.面试01;

public class demo1{
    public static void main(String[] args){
        User user= new User();
        if(user.hasPrivilege(45494)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
    static class User{
        private int USER_PRIVILEGE_DELETE=512;
        //补全代码
        public Boolean hasPrivilege(int userPrivilege){
            return (USER_PRIVILEGE_DELETE & userPrivilege) == USER_PRIVILEGE_DELETE;
        }
    }
}