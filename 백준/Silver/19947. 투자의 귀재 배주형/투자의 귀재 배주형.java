
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H=sc.nextInt();
        int Y=sc.nextInt();
        long[] dp = new long[Y+1];
        dp[0] = H;
        for(int i=1;i<=Y;i++) {
            dp[i] = (long) (dp[i-1] * 1.05);
            if (i >= 3) {
                dp[i] = Math.max(dp[i], (long) (dp[i-3] * 1.2));
            }
            if (i >= 5) {
                dp[i] = Math.max(dp[i], (long) (dp[i-5] * 1.35));
            }
        }
        System.out.println((int) dp[Y]);
    }
}
