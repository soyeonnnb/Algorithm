import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[][] dp = new int[K+1][N+1]; // 무게, 몇번째까지 선택
        for(int i=1;i<=K;i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j=1;j<=N;j++) {
                if (j<t) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j-t] + w, dp[i-1][j]);
            }
        }
        System.out.println(dp[K][N]);
    }
}