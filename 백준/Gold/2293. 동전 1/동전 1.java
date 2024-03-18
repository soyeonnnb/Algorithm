import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(br.readLine());
        int[][] dp = new int[K+1][N+1];
        Arrays.fill(dp[0], 1);
        for(int i=1;i<=K;i++) {
            for(int j=1;j<=N;j++) {
                if (arr[j] > i) dp[i][j] = dp[i][j-1];
                else {
                    dp[i][j] = dp[i-arr[j]][j] + dp[i][j-1];
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}