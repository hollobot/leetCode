package contest.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 统计结果等于K的序列数目 {

    public static void main(String[] args) {
        int[] nums = {5, 3, 5};
        int count = countSequences(nums, 3);
        System.out.println(count);
    }

    public static Map<String, int[]> memo = new HashMap();

    public static int countSequences(int[] nums, long k) {
        int len = nums.length;
        return dfs(nums, len - 1, k, 1);
    }

    public static int dfs(int[] nums, int i, long k, long m) {
        if (k == m && i == -1) {
            return 1;
        }

        if (i < 0) {
            return 0;
        }

        String key = k + "/" + m;
        int[] row = memo.get(key);
        if (row != null && row[i] != -1) {
            return row[i];
        }

        int count = dfs(nums, i - 1, k * nums[i], m) + dfs(nums, i - 1, k, m * nums[i]) + dfs(nums, i - 1, k, m);
        if (row == null) {
            row = new int[nums.length];
            Arrays.fill(row, -1);
            memo.put(key, row);
        }
        row[i] = count;
        return count;
    }
}
