package contest.第495场周赛;

import java.util.*;

public class EventManager {

    Map<Integer, Integer> map;
    Queue<int[]> queue;

    public EventManager(int[][] events) {
        queue = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        map = new HashMap();
        for (int[] row : events) {
            map.put(row[0], row[1]);
            queue.offer(new int[]{row[0], row[1]});
        }
    }

    // 修改eventId的newPriority
    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId, newPriority);
        queue.offer(new int[]{eventId, newPriority});
    }

    // 移除优先级最高的，出现多个一样的优先级移除eventId最小的
    public int pollHighest() {
        int[] poll = queue.poll();
        if(poll == null){
            return -1;
        }
        if (map.get(poll[0])!=null && map.get(poll[0]).equals(poll[1])) {
            map.remove(poll[0]);
            return poll[0];
        }
        return pollHighest();
    }
}
