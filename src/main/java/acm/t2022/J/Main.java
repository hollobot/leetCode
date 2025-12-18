package acm.t2022.J;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Long> fibs = new ArrayList<>();
    static long max = (long) Math.pow(10, 15);


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 初始化数据
        fibs.add(1L);
        fibs.add(1L);
        while (true) {
            long num = fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2);
            fibs.add(num);
            if (num > max) {
                break;
            }
        }

        while (sc.hasNextLong()) {
            long n = sc.nextLong();
            check(n);
        }
    }

    public static void check(long num) {
        long sum = 0;
        for (int i = 0; i < fibs.size(); i++) {
            sum = fibs.get(i);
            if(sum == num) {
                System.out.println("YES");
                return;
            }
            if (sum > num) {
                System.out.println("NO");
                return;
            }
            for (int j = i+1; j < fibs.size(); j++) {
                sum += fibs.get(j);
                if (sum == num) {
                    System.out.println("YES");
                    return;
                }
                if (sum > num) {
                    break;
                }
            }
        }
        System.out.println("NO");
    }
}
