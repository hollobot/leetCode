package contest.第501场周赛;

import java.util.HashMap;
import java.util.Map;

public class 有效单词计数 {

    public static void main(String[] args) {
        String[] chunks = new String[] {"x--hp m-ym - -lf-"};
        String[] queries = new String[] {"m-ymj","x","m-ym","hp","lf"};
        new 有效单词计数().countWordOccurrences(chunks, queries);
    }

    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        int len = chunks.length;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str.append(chunks[i]);
        }
        str.append(" ");

        Map<String, Integer> map = new HashMap<>();
        int l = 0;
        boolean flag = false;
        int size = str.length();
        for (int i = 0; i < size; i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                flag = false;
                continue;
            }
            String key;
            if (!flag && c == '-' && i!=l) {
                flag = true;
                continue;
            } else if (flag) {
                key = str.substring(l, i - 1);
            } else {
                key = str.substring(l, i);
            }

            if (key.length() != 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            flag = false;
            l = i + 1;
        }

        System.out.println(map);
        len = queries.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            Integer count = map.get(queries[i]);
            ans[i] = count == null ? 0 : count;
        }

        return ans;
    }
}
