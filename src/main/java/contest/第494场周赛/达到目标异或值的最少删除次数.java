package contest.第494场周赛;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 达到目标异或值的最少删除次数 {

    private Map<Integer, Integer>[] memo;
    private int[] nums;

    @Test
    public void test1() {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(minRemovals(nums, 2));
    }

    public int minRemovals(int[] nums, int target) {
        int len = nums.length;
        this.nums = nums;
        this.memo = new HashMap[len];
        for (int i = 0; i < len; i++) {
            memo[i] = new HashMap();
        }
        int minCount = dfs(0, target);
        return minCount > len ? -1 : minCount;
    }

    public int dfs(int index, int xor) {

        if (index == nums.length) {
            return xor == 0 ? 0 : nums.length + 1;
        }

        if (memo[index].get(xor) != null) {
            return memo[index].get(xor);
        }
        int t = Math.min(dfs(index + 1, xor) + 1, dfs(index + 1, xor ^ nums[index]));
        memo[index].put(xor, t);
        return t;
    }
}
