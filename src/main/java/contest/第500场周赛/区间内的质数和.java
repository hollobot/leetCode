package contest.第500场周赛;

public class 区间内的质数和 {

    public static void main(String[] args) {
        new 区间内的质数和().sumOfPrimesInRange(10);
    }

    public int sumOfPrimesInRange(int n) {
        int sum = 0;
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        StringBuilder reverse = sb.reverse();
        int ren = Integer.parseInt(reverse.toString());
        int min = Math.max(Math.min(n, ren),2);
        int max = Math.max(n, ren);
        for (int i = min; i <= max; i++) {
            sum += fun(i);
        }

        return sum;
    }

    public int fun(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return 0;
            }
        }

        return n;
    }
}
