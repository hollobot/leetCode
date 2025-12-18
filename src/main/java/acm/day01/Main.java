package acm.day01;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int e = in.nextInt();
        in.nextLine();
        in.nextLine();
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<e;i++){
            int num = in.nextInt();
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Integer i : map.keySet()){

        }
    }
}
