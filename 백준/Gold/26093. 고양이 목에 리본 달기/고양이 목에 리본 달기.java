import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15:27 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][K];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<K;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N][K];
        for(int j=0;j<K;j++) dp[0][j] = arr[0][j];
        int[][] max = new int[2][2];
        for(int i=1;i<N;i++) {
            if (dp[i-1][0] < dp[i-1][1]) {
                max[0][0] = dp[i-1][1];
                max[0][1] = 1;
                max[1][0] = dp[i-1][0];
                max[1][1] = 0;
            } else {
                max[0][0] = dp[i-1][0];
                max[0][1] = 0;
                max[1][0] = dp[i-1][1];
                max[1][1] = 1;
            }
            for(int j=2;j<K;j++) {
                if (max[0][0] <= dp[i-1][j]) {
                    max[1][0] = max[0][0];
                    max[1][1] = max[0][1];
                    max[0][0] = dp[i-1][j];
                    max[0][1] = j;
                } else if (max[1][0] < dp[i-1][j]) {
                    max[1][0] = dp[i-1][j];
                    max[1][1] = j;
                }
            }
            for(int j=0;j<K;j++) {
                if (max[0][1] == j) { // 가장 큰 값이 해당 리본이면
                    dp[i][j] = arr[i][j] + max[1][0]; // 두번째로 큰 값을 더함
                    continue;
                }
                dp[i][j] = arr[i][j] + max[0][0];
            }
        }
        int ans = 0;
        for(int j=0;j<K;j++) ans = Math.max(ans, dp[N-1][j]);
        System.out.println(ans);
    }
}