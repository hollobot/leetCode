package contest.第497场周赛;

import java.util.*;

public class 多源洪水灌溉 {

    public static void main(String[] args) {
        int[][] r = new 多源洪水灌溉().colorGrid(3, 3, new int[][] {{0, 1, 3}, {1, 1, 5},});

        System.out.println(Arrays.toString(r));

    }

    private int n;
    private int m;
    private int[][] ans;

    public int[][] colorGrid(int n, int m, int[][] sources) {
        this.n = n;
        this.m = m;
        this.ans = new int[n][m];
        List<int[]> list = new ArrayList();

        for (int i = 0; i < sources.length; i++) {
            if (sources[i][2] != 0) {
                list.add(sources[i]);
                ans[sources[i][0]][sources[i][1]] = sources[i][2];
            }
        }

        while (list.size() > 0) {
            int listSize = list.size();
            Map<String, Integer> map = new HashMap();
            for (int i = 0; i < listSize; i++) {
                int[] ints = list.get(i);
                int x = ints[0];
                int y = ints[1];
                int color = ints[2];

                fun(map, x, y, color, false);
                fun(map, x - 1, y, color, true);
                fun(map, x, y - 1, color, true);
                fun(map, x + 1, y, color, true);
                fun(map, x, y + 1, color, true);

            }

            list.clear();
            for (String key : map.keySet()) {
                Integer c = map.get(key);
                String[] split = key.split("-");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                ans[x][y] = c;
                int[] arr = new int[] { x, y, c };
                list.add(arr);
            }
        }
        return ans;
    }

    public void fun(Map<String, Integer> map, int x, int y, int color, boolean isAdd) {
        if (!(x < n && x >= 0 && y < m && y >= 0)) {
            return;
        }

        String key = x + "-" + y;
        Integer c = map.get(key);
        if (isAdd && ans[x][y] == 0 && (c == null || c < color)) {
            map.put(key, color);
        }
    }
}
