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
        int x=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][2];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][x+1];
        dp[0][0] = 1;
        for(int i=1;i<=N;i++) {
            for(int k=0;k<=x;k++) {
                for(int j=0;j<=arr[i][1];j++) {
                    if (k - j*arr[i][0] < 0) break;
                    if (dp[i-1][k-j*arr[i][0]] == 0) continue;
                    dp[i][k] += dp[i-1][k-j*arr[i][0]];
                }
            }
        }

        System.out.println(dp[N][x]);
    }
}