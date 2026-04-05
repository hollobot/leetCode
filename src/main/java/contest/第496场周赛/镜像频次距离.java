package contest.第496场周赛;

public class 镜像频次距离 {

    public static void main(String[] args) {
        String s = "ab1z9";
        mirrorFrequency(s);
    }

    public static int mirrorFrequency(String s) {
        int[] e = new int[26];
        int[] nums = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                nums[c - '0']++;
            } else {
                e[c - 'a']++;
            }
        }

        int sum = 0;

        int numsL = nums.length - 1;
        for (int i = 0; i <= numsL / 2; i++) {
            sum += Math.abs(nums[numsL - i] - nums[i]);
        }

        int eL = e.length - 1;
        for (int i = 0; i <= eL / 2; i++) {
            sum += Math.abs(e[eL - i] - e[i]);
        }

        return sum;
    }
}
