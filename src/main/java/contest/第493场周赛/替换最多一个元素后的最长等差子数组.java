package contest.第493场周赛;

public class 替换最多一个元素后的最长等差子数组 {

    public static void main(String[] args) {
        int[] nums = new int[] {9, 7, 5, 10, 1};
        System.out.println(longestArithmetic(nums));

    }

    public static int longestArithmetic(int[] nums) {

        int[] pre = calc(nums, 1);
        int[] suf = calc(nums, -1);

        int max = 0;
        for (int n : pre) {
            max = Math.max(max, n);
        }

        int len = nums.length;
        if (max >= len) {
            return len;
        }

        for (int i = 1; i < len - 1; i++) {
            int d2 = nums[i + 1] - nums[i - 1];
            if (d2 % 2 != 0) {
                continue;
            }

            boolean l = i > 1 && (nums[i - 1] - nums[i - 2]) == d2 / 2;
            boolean r = i < len - 2 && (nums[i + 2] - nums[i + 1]) == d2 / 2;
            if (l && r) {
                max = Math.max(max, pre[i - 1] + 1 + suf[i + 1]);
            } else if (l) {
                max = Math.max(max, pre[i - 1] + 2);
            } else if (r) {
                max = Math.max(max, 2 + suf[i + 1]);
            }
        }

        return max;

    }

    public static int[] calc(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len];
        int j = 2;
        if (k == 1) {
            ans[0] = 1;
            ans[1] = 2;
        } else if (k == -1) {
            ans[len - 1] = 1;
            ans[len - 2] = 2;
            j = len - 3;
        }
        for (int i = j; i < len && i >= 0; i += k) {
            if ((nums[i - 2 * k] + nums[i]) == nums[i - k] * 2) {
                ans[i] = ans[i - k] + 1;
            } else {
                ans[i] = 2;
            }
        }

        return ans;
    }
}
