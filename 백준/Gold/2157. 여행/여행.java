import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.max(arr[a][b], c);
        }
        int[][] dp = new int[N+1][M+1];
        for(int i=1;i<=N;i++) Arrays.fill(dp[i], -1);

        dp[1][1] = 0;

        // 몇 번째 도시
        for(int i=1;i<=N;i++) {
            // 몇 번째로 도달하는 건지
            for(int j=2;j<=M;j++) {
                // 출발지점
                for(int k=1;k<i;k++) {
                    if (arr[k][i] == 0 || dp[k][j-1] == -1) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[k][j-1] + arr[k][i]);
                }
            }
        }
        int ans = 0;
        for(int k=1;k<=M;k++) ans = Math.max(ans, dp[N][k]);
        System.out.println(ans);
    }
}