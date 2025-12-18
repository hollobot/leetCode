package acm.t2022.D;

import java.util.Scanner;

public class Main {

    public static final int NUM = (int) Math.pow(10, 9) + 7;

    public static long sum = 0L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            sum = 0;
            compute(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            System.out.println(sum % NUM);
        }
    }

    public static void compute(int n, int a1, int a2, int b1, int b2) {
        int c = n - 1;
        if (c < 0) {
            return;
        }
        sum = sum + 2 * (a1 * c) + 2 * (a2 * c)+ 2 * (b1 * c)+ 2 * (b2 * c)+1;
        compute(n - 1, a1, a2, b1, b2);
    }
}
