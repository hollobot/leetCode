package acm.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] arr = new int[n];

        int totalSum = 0;
        for(int i=0;i<n;i++){
            arr[i] = nextInt();
            totalSum+=arr[i];
        }
        if(totalSum < 0){
            System.out.println(0);
            return;
        }

        int count = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            boolean flog = true;
            for(int j=0;j<n;j++){
                sum += arr[(i+j)%n];
                if(sum < 0 ){
                    flog = false;
                    break;
                }
            }
            if(flog){
                count++;
            }
        }

        System.out.println(count);
    }
}
