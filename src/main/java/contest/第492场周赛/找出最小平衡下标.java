package contest.第492场周赛;

public class 找出最小平衡下标 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,1};
        System.out.println(smallestBalancedIndex(arr));
    }

    public static int smallestBalancedIndex(int[] nums) {
        long sum = 0;
        long ans = 1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (sum < ans) {
                sum += nums[l++];
            }

            if (sum > ans) {
                ans *= nums[r--];
            }

            if (sum == ans && l == r) {
                return l;
            }

            if (sum == ans) {
                ans *= nums[r--];
            }
        }

        return -1;
    }
}
