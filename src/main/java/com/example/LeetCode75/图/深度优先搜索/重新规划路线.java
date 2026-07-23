package com.example.LeetCode75.图.深度优先搜索;

import java.util.*;

public class 重新规划路线 {

    public static void main(String[] args) {
        int[][] ints = {{4, 5}, {0, 1}, {1, 3}, {2, 3}, {4, 0}};
        minReorder(5, ints);

    }

    public static int minReorder(int n, int[][] connections) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int count = 0;
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(connections, (e1, e2) -> {
            boolean b1 = e1[0] == 0 || e1[1] == 0;
            boolean b2 = e2[0] == 0 || e2[1] == 0;
            if (b1 && !b2) {
                return -1;
            }

            if (!b1 && b2) {
                return 1;
            }
            return 0;
        });

        for (int[] connection : connections) {
            if (visited.contains(connection[0]) && !visited.contains(connection[1])) {
                count++;
                visited.add(connection[1]);
                continue;
            }

            if (visited.contains(connection[1]) && !visited.contains(connection[0])) {
                visited.add(connection[0]);
                continue;
            }
            stack.push(new int[] {connection[0], connection[1]});
        }

        while (!stack.isEmpty()) {
            int[] connection = stack.pop();
            if (visited.contains(connection[0]) && !visited.contains(connection[1])) {
                count++;
                visited.add(connection[1]);
                continue;
            }

            if (visited.contains(connection[1]) && !visited.contains(connection[0])) {
                visited.add(connection[0]);
                continue;
            }
            stack.add(new int[] {connection[0], connection[1]});
        }
        return count;
    }

}
