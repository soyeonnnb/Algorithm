import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        long X=sc.nextLong() ;
        long[] length = new long[N+1];
        long[] count= new long[N+1];
        length[0] = 1;
        count[0] = 1;
        for(int i=1;i<=N;i++) {
            length[i] = length[i-1] * 2 + 3;
            count[i] = count[i-1] * 2 + 1;
        }
        long ans = 0;
        for(int i=N;i>=0;i--) {
            if (i == 0) {
                ans++;
            } else if (X == 1) {
                break;
            } else if (X <= 1 + length[i-1]) {
                X-=1;
            } else if (X == 2 + length[i-1]) {
                ans += 1 + count[i-1];
                break;
            } else if (X <= 2 + length[i-1] * 2) {
                ans += 1 + count[i-1];
                X -= 2 + length[i-1];
            } else {
                ans += 1 + 2 * count[i-1];
                break;
            }
        }
        System.out.println(ans);
    }
}