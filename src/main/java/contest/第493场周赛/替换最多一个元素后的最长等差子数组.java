package contest.第493场周赛;

public class 替换最多一个元素后的最长等差子数组 {

    public static void main(String[] args) {
        int[] nums = new int[] {9, 7, 5, 10, 1};
        System.out.println(longestArithmetic(nums));

    }

    public static int longestArithmetic(int[] nums) {
        int len = nums.length;
        int max = 2;
        for (int i = 1; i < len - 1; i++) {
            int sum = nums[i + 1] + nums[i - 1];
            if (sum % 2 != 0) {
                continue;
            }
            int tem = nums[i];
            nums[i] = sum / 2;
            max = Math.max(max, dfs(nums, i, nums[i + 1] - nums[i]));
            nums[i] = tem;
        }

        return max;
    }

    public static int dfs(int[] nums, int index, int d) {
        int len = nums.length;
        int l = index - 1;
        int r = index + 1;
        int count = 1;
        boolean flag1 = true, flag2 = true;
        while (flag1 || flag2) {
            if (l >= 0 && nums[l] + d == nums[l + 1]) {
                count++;
                l--;
            } else {
                flag1 = false;
            }

            if (r < len && nums[r - 1] + d == nums[r]) {
                count++;
                r++;
            } else {
                flag2 = false;
            }

        }

        return count;
    }
}
