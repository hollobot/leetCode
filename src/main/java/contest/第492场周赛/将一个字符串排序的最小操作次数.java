package contest.第492场周赛;

public class 将一个字符串排序的最小操作次数 {

    public int minOperations(String s) {
        int len = s.length();
        if (len == 1) {
            return 0;
        }

        if (len == 2) {
            return s.charAt(0) <= s.charAt(1) ? 0 : -1;
        }

        return dfs(s);
    }

    public int dfs(String s) {
        int len = s.length();
        int max = 0;
        int flog = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                flog = 0;
            }
            if (s.charAt(max) < s.charAt(i)) {
                max = i;
            }
        }

        if (flog == 1) {
            return 0;
        }

        if (max == len - 1) {
            return 1;
        }

        s = s.substring(0, max) + s.charAt(len - 1) + s.substring(max + 1, len - 1);

        return 1 + dfs(s);
    }
}
