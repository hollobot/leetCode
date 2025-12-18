package com.example.securityCode;

import java.util.Hashtable;


public class SecurityCode {

    /** 5min有效时间 */
    private static final long EXPIRE_TIME = 5 * 60 * 1000;
    /** 掩码 */
    private static final String SERVER_SECRET = "hello";

    /** 生成有效期 5 分钟的 key */
    public static String generateKey() {
        return xorEncrypt(String.valueOf(System.currentTimeMillis() + EXPIRE_TIME), SERVER_SECRET);
    }

    /** 加密/解密 */
    public static String xorEncrypt(String data, String mask) {
        char[] res = new char[data.length()];
        for (int i = 0; i < data.length(); i++) {
            res[i] = (char) (data.charAt(i) ^ mask.charAt(i % mask.length()));
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put(null,"2");
        System.out.println(hashtable.get(null));
    }

}
