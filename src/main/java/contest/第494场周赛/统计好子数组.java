package contest.第494场周赛;

import java.util.ArrayList;
import java.util.List;

public class 统计好子数组 {

    public static void main(String[] args) {
        int[] arr = new int[] {4, 2, 3};
        System.out.println(countGoodSubarrays(arr));
    }

    public static long countGoodSubarrays(int[] nums) {
        int n = nums.length;
        long result = 0;

        // 每个元素: [OR值, max值, 左端点个数]
        // 对当前右端点 r，记录所有不同 (or, max) 组合的左端点数量
        // groups 按 OR 值从小到大排列（对应左端点从右到左）
        List<int[]> groups = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            int num = nums[r];

            // 1. 新建以 r 为左端点的组
            List<int[]> next = new ArrayList<>();
            next.add(new int[] {num, num, 1});

            // 2. 将已有所有组 OR 上 v，合并 (or, max) 相同的组
            for (int[] g : groups) {
                int newOr = g[0] | num;
                int newMax = Math.max(g[1], num);
                int[] last = next.get(next.size() - 1);

                if (last[0] == newOr && last[1] == newMax) {
                    // (or, max) 完全相同 → 合并，只累加 count
                    last[2] += g[2];
                } else {
                    next.add(new int[] {newOr, newMax, g[2]});
                }
            }
            groups = next;

            // 3. 统计满足 OR == max 的左端点数
            for (int[] g : groups) {
                if (g[0] == g[1]) {   // OR值 == max值 → 好子数组
                    result += g[2];
                }
            }
        }

        return result;
    }
}
