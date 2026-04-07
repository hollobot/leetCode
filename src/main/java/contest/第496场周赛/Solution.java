package contest.第496场周赛;

import java.util.*;

/**
 * 可由多种立方和构造的整数
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(1);
    }

    public static Integer mx = (int)Math.pow(10, 9);
    public static final List<Integer> list = new ArrayList();

    public Solution() {

        Map<Integer, Integer> map = new HashMap();
        int len = (int)Math.sqrt(mx);
        for (int a = 1; a <= len; a++) {
            for (int b = a; b <= mx; b++) {
                map.merge(a * a * a + b * b * b, 1, Integer::sum);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);
    }

    public List<Integer> findGoodIntegers(int n) {
        // 2分查找
        int i = Collections.binarySearch(list, n);
        return list.subList(0, i + 1);
    }
}
