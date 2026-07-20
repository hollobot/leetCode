package com.example.LeetCode75.图.深度优先搜索;

public class 省份数量 {

    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {

        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int size = 0;
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            size++;
            visited[i] = true;
            dfs(visited, isConnected, len, i);
        }
        return size;
    }

    public void dfs(boolean[] visited, int[][] isConnected, int len, int i) {
        for (int j = 0; j < len; j++) {
            if (isConnected[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                dfs(visited, isConnected, len, j);
            }
        }
    }
}
