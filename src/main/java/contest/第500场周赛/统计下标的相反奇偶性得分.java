package contest.第500场周赛;

public class 统计下标的相反奇偶性得分 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        new 统计下标的相反奇偶性得分().countOppositeParity(nums);
    }

    public int[] countOppositeParity(int[] nums) {
        int len = nums.length;
        int[] q = new int[len + 1];
        int[] o = new int[len + 1];
        int[] ans = new int[len];
        q[len] = 0;
        o[len] = 0;

        for (int i = len - 1; i >= 0; i--) {
            int num = nums[i];
            if ((num & 1) == 1) {
                ans[i] = o[i + 1];
                q[i] = q[i + 1] + 1;
                o[i] = o[i + 1];
            } else {
                ans[i] = q[i + 1];
                o[i] = o[i + 1] + 1;
                q[i] = q[i + 1];
            }
        }

        return ans;
    }
}
