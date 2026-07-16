package com.example.面试.华为OD笔试;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C {

    public static void main(String[] args) {

        C c = new C();

        int[][] e = new int[][] {{1, 2, 5}, {2, 3, 5}, {3, 4, 5}, {1, 4, 25}};
        int i = c.FindMinCost(4, 4, 20, e);
        System.out.println(i);

    }

    private int min = Integer.MAX_VALUE;
    private Map<String, Integer> map;
    private Map<Integer, List<Integer>> cost;

    public int FindMinCost(int cityCount, int routeCount, int maxBudget, int[][] edges) {
        map = new HashMap<>();
        cost = new HashMap<>();
        for (int[] row : edges) {
            map.put(row[0] + "-" + row[1], row[2]);
            cost.computeIfAbsent(row[0], k -> new ArrayList<>()).add(row[1]);
        }
        dfs(1, cityCount, maxBudget, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void dfs(int l, int r, int maxBudget, int money) {
        if (money > maxBudget) {
            return;
        }

        if (l == r) {
            min = Math.min(min, money);
            return;
        }

        List<Integer> integers = cost.get(l);
        if (integers == null) {
            return;
        }
        for (Integer integer : integers) {
            Integer m = map.get(l + "-" + integer);
            dfs(integer, r, maxBudget, money + m);
        }

    }
}
