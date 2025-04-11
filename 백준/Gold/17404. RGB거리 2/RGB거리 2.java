
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[N][3][3];

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if (i == j) dp[0][i][j] = arr[0][i]; // 0번째 집을 칠하는 비용
                else dp[0][i][j] = 1_000_000; // 이 전에 색칠할 수는 없으니까 일단 최대값
            }
        }
        for(int i=1;i<N;i++) { // i 번째 집을 색칠할거임
            for(int j=0;j<3;j++) { // j 색으로 색칠할거임
                for(int k=0;k<3;k++) { // 첫번째 집이 k번째 색으로 칠했을 때의 경우의 수
                    dp[i][j][k] = Math.min(dp[i-1][(j+1)%3][k], dp[i-1][(j+2)%3][k]) + arr[i][j];
                }
            }
        }
        int ans = dp[N-1][0][1]; // N = 0번째, 1 = 1번째 색으로 칠함
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if (i == j) continue;
                ans = Math.min(ans, dp[N-1][i][j]);
            }
        }
        System.out.println(ans);

    }
}
