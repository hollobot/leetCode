package acm.C;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 复制并排序得到目标数组
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // 找出所有不同的位置
        int diffCount = 0;
        int pos1 = -1, pos2 = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] != sorted[i]) {
                diffCount++;
                if (pos1 == -1) {
                    pos1 = i;
                } else if (pos2 == -1) {
                    pos2 = i;
                }
            }
        }

        // 判断结果
        if (diffCount == 0) {
            // 已经有序
            System.out.println("Sorted");
        } else if (diffCount == 2) {
            // 恰好两个位置不同，检查交换后是否正确
            if (arr[pos1] == sorted[pos2] && arr[pos2] == sorted[pos1]) {
                System.out.println("Sorted");
            } else {
                System.out.println("Failed");
            }
        } else {
            // 超过两个位置不同
            System.out.println("Failed");
        }
    }
}