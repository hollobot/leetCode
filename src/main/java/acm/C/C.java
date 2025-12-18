package acm.C;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] split = s.split(" ");

        int l = 0,r = split.length-1;

        int offset = 0;

        for(int i=l+1;i<split.length;i++){
            int mum1 = Integer.parseInt(split[i-1]);
            int mum2 = Integer.parseInt(split[i]);
            if(mum1 == mum2){
                offset++;
                continue;
            }
            if(mum1>mum2){
                l = i-1-offset;
                break;
            }
            offset = 0;
        }

        offset = 0;
        for(int i=r-1;i>=0;i--){
            int mum1 = Integer.parseInt(split[i]);
            int mum2 = Integer.parseInt(split[i+1]);
            if(mum1 == mum2){
                offset++;
                continue;
            }
            if(mum1>mum2){
                r = i+1-offset;
                break;
            }
            offset = 0;
        }

        //交换
        String temp = split[l];
        split[l] = split[r];
        split[r] = temp;

        for(int i=1;i<split.length;i++){
            int mum1 = Integer.parseInt(split[i-1]);
            int mum2 = Integer.parseInt(split[i]);
            if(mum1>mum2){
                System.out.println("Failed");
                return;
            }
        }
        System.out.println("Sorted");

    }
}
