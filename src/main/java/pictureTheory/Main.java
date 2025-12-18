package pictureTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        canFinish(2,new int[][]{
                {1,0}
        });
    }

    static List<List<Integer>> edges;
    static int[] indeg;

    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList();
        int[] arr = new int[numCourses];
        List<List<Integer>> list = new ArrayList();
        int visited =0;

        for(int i =0;i<numCourses;i++){
            list.add(new ArrayList());
        }

        for(int[] a : prerequisites){
            arr[a[0]]++;
            list.get(a[1]).add(a[0]);
        }

        System.out.println(list);

        // 添加最开始可以学习的那批进入队列
        for(int i=0;i<numCourses;i++){
            if(arr[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            visited++;
            int u = queue.poll();
            for(Integer index : list.get(u)){
                arr[index]--;
                if(arr[index]==0){
                    queue.offer(index);
                }
            }
        }

        return visited==numCourses;
    }
}

