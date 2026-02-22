package contest.one;

import java.util.HashMap;
import java.util.Map;

public class 阶数数字排列 {

    public static void main(String[] args) {
        System.out.println(0.0==0);
    }



    public boolean isDigitorialPermutation(int n) {
        int sum = 0;
        int num = n;
        while (num != 0) {
            sum += factorial(num % 10);
            num = num / 10;
        }

        String num1 = n + "";
        String num2 = sum + "";
        if (num1.length() != num2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < num1.length(); i++) {
            Character c = num1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < num2.length(); i++) {
            Character c = num2.charAt(i);
            Integer count = map.get(c);
            if (count == null) {
                return false;
            }

            if (--count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }

        }

        return map.size() == 0;
    }

    public int factorial(int num) {
        if (num == 0) {
            return 1;
        }

        if (num == 1) {
            return 1;
        }

        return num * factorial(num - 1);
    }
}
