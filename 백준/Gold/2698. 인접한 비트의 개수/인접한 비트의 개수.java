import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int[][][] dp;
        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            dp = new int[N+1][2][K+1]; // N까지의 수, 현재가 0/1일 떄, 인접한 비트수
            dp[1][0][0] = 1;
            dp[1][1][0] = 1;
            for(int i=2;i<=N;i++) { // 현재 몇번째 숫자
                for(int k=0;k<=K;k++) { // 현재까지 몇개의 인접한 비트수를 넣을 건지
                    // 이번에 0 을 넣을거
                    dp[i][0][k] = dp[i-1][0][k] + dp[i-1][1][k];
                    // 이번에 1을 넣을거
                    dp[i][1][k] = dp[i-1][0][k];
                    if (k != 0) dp[i][1][k] += dp[i-1][1][k-1];
                }
            }
            System.out.println(dp[N][0][K] + dp[N][1][K]);
        }
    }
}
