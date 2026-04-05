package contest.第496场周赛;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 可由多种立方和构造的整数 {

    public static void main(String[] args) {
        findGoodIntegers(4104);
    }

    public static List<Integer> findGoodIntegers(int n) {
        Set<Integer> set = new HashSet();
        for (int i = n; i >= 1; i--) {
            double max = Math.sqrt(i);
            int count = 0;
            int a = 1, b = (int)max;
            while (a < b) {
                if (2 * Math.pow(b, 3) < i) {
                    break;
                }
                int num = (int)(Math.pow(a, 3) + Math.pow(b, 3));
                if (num < i) {
                    a++;
                } else if (num > i) {
                    b--;
                } else {
                    count++;
                    b--;
                    a = 1;
                }

                if(count==2){
                    set.add(a);
                    break;
                }
            }
        }

        return set.stream().toList();
    }
}
