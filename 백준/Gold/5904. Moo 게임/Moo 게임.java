import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] length = new long[35];
        length[3] = 3;
        for(int i=4;i<=34;i++) length[i] = length[i-1]*2 + i;
        int N=sc.nextInt();
        char ans = 'o';
        for(int i=34;i>=3;i--) {
            if (N > length[i-1] + i) {
                N -= length[i-1] + i;
            } else if (N > length[i-1]) {
                N -= length[i-1];
                if (N == 1) ans = 'm';
                break;
            }
        }
        if (N == 0) ans = 'm';
        System.out.print(ans);
    }
}