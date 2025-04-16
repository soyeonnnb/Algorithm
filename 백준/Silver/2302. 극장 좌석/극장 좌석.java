
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static int N, M;
    private static Set<Integer> set;
    private static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        set = new HashSet<>();
        for(int i=0;i<M;i++) set.add(sc.nextInt());
        dp = new int[N+1][3];
        dp[0][1] = 1;
        for(int i=1;i<=N;i++){
            if (set.contains(i)) {
                dp[i][1] = dp[i-1][0] + dp[i-1][1];
            } else {
                dp[i][0] = dp[i-1][2];
                if (dp[i-1][0] != 0) {
                    dp[i][0] -= dp[i-2][2];
                }
                dp[i][1] = dp[i-1][0] + dp[i-1][1];
                if (i != N) {
                    dp[i][2] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
                }

            }
        }
        System.out.println(dp[N][0] + dp[N][1] + dp[N][2]);
    }
}
