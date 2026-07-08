package com.example.面试.面试01;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class demo3 {

    public static void main(String[] args) {
        try {
            // 1. 下载文件到内存
            byte[] data = downloadFile("http://www.corget.com/DownloadServer/download/Files/order");

            // 2. 按协议依次解析字段
            int idx = 0;

            // cmd: byte, 1字节
            byte cmd = data[idx];
            idx += 1;

            // id: long, 8字节，小端序
            long id = 0;
            for (int i = 0; i < 8; i++) {
                id |= ((long) (data[idx + i] & 0xFF)) << (8 * i);
            }
            idx += 8;

            // dist: short, 2字节，小端序
            int dist = (data[idx] & 0xFF) | ((data[idx + 1] & 0xFF) << 8);
            idx += 2;

            // fee: short, 2字节，小端序
            int fee = (data[idx] & 0xFF) | ((data[idx + 1] & 0xFF) << 8);
            idx += 2;

            // date, src, des, url, other：均为字符串，以'\0'结束
            int[] pos = {idx};
            String date = readString(data, pos);
            String src = readString(data, pos);
            String des = readString(data, pos);
            String url = readString(data, pos);
            String other = readString(data, pos);

            System.out.println("id:" + id);
            System.out.println("url:" + url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从pos位置开始读取一个以\0结尾的字符串，并更新pos为下一个字段的起始位置
     */
    private static String readString(byte[] data, int[] pos) {
        int start = pos[0];
        int end = start;
        while (data[end] != 0) {
            end++;
        }
        String s = new String(data, start, end - start, java.nio.charset.StandardCharsets.UTF_8);
        pos[0] = end + 1; // 跳过'\0'
        return s;
    }


    private static byte[] downloadFile(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        try (InputStream in = conn.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            return out.toByteArray();
        } finally {
            conn.disconnect();
        }
    }
}