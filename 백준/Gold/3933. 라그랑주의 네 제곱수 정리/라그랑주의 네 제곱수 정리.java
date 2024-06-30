import java.io.IOException;
import java.util.*;


public class Main {
    private static int[][][] dp;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        dp = new int[40001][182][4];
        for(int i=1;i<=40000;i++) {
            for(int j=1;j<=181;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int i=1;i<=181;i++) dp[i*i][i][0] = 1;
        while(true) {
            int num = sc.nextInt();
            if (num == 0) break;
            int ans = 0;
            for(int i=0;i<4;i++) { // i+1개의 수를 써서 만든 수
                for(int j=1;j<=181;j++) { // 최대 j*j를 써서 만든 수 개수
                    if (j*j > num) break; // j*j가 num 보다 크면 의미 없음
                    ans += recur(num-j*j, j, i-1);
                }
            }
            System.out.println(ans);
        }

    }

    // num 이란 수를, count개의 수를 사용해서, max*max를 써서 만든 수의 개수
    private static int recur(int num, int max, int count) {
        if (num == 0 && count == -1) {
            return 1;
        }
        if (count == -1) return 0;
        if (dp[num][max][count] != -1) return dp[num][max][count];

        dp[num][max][count] = 0;
        for(int i=1;i<=max;i++) {
            if (num < i*i) break;
            dp[num][max][count] += recur(num-i*i, i, count-1);
        }

        return dp[num][max][count];
    }

}