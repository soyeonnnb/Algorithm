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
        int M=Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M];
        for(int j=0;j<M;j++) {
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][M];

        for(int i=0;i<M;i++) dp[1][i] = arr[1][i];

        for(int i=2;i<=N;i++) { // 며칠째인지
            for(int j=0;j<M;j++) { // 이 디저트 선택할건데
                for(int k=0;k<M;k++) { // 전날에는 이 디저트 먹을거임
                    if (j == k) dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + arr[i][j]/2);
                    else dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + arr[i][j]);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<M;i++) ans = Math.max(ans, dp[N][i]);
        System.out.println(ans);
    }
}