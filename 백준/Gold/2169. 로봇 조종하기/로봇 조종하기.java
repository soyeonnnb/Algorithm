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
        int[][] arr = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][][] dp = new int[N+2][M+2][3]; // 가로, 세로, 위/왼/오 에서 온거
        for(int i=0;i<=N+1;i++) for(int j=0;j<=M+1;j++) Arrays.fill(dp[i][j], -2000000000);
        for(int k=0;k<3;k++) dp[1][1][k] = arr[1][1];

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                if (i == 1 && j == 1) continue;
                dp[i][j][0] = Math.max(dp[i-1][j][0], Math.max(dp[i-1][j][1], dp[i-1][j][2])) + arr[i][j];
                dp[i][j][1] = Math.max(dp[i][j-1][0], dp[i][j-1][1]) + arr[i][j];
            }
            for(int j=M;j>=1;j--) dp[i][j][2] = Math.max(dp[i][j+1][0], dp[i][j+1][2]) + arr[i][j];
        }
        System.out.println(Math.max(dp[N][M][0], Math.max(dp[N][M][1], dp[N][M][2])));
    }
}