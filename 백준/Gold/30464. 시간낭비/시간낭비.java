import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11:15 ~
public class Main {
    private static int N;
    private static int[] arr;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        // [0]: 해당 칸에서 N 까지 가는 경로 수
        // [1]: 해당 칸에서 백했을 때 몇칸 갈 수 있는지
        dp = new int[2][N];
        for(int i=0;i<2;i++) Arrays.fill(dp[i], -1);
        dp[0][N-1] = 0;

        for(int i=N-2;i>=0;i--) {
            int nxt = i + arr[i];
            if (nxt >= N || dp[0][nxt] == -1) continue;
            dp[0][i] = dp[0][nxt] + 1;
        }

        dp[1][0] = -1;
        // 해당 칸에서 뒤로 백했을 때 최대값
        for(int i=1;i<N;i++) {
            int back = i - arr[i];
            if (back < 0) continue;
            if (dp[0][i] == -1 && dp[0][back] == -1 && dp[1][back] == -1) continue;
            dp[1][i] = Math.max(dp[0][i], Math.max(dp[0][back], dp[1][back]) + 1);
        }

        int now = 0;
        int ans = dp[0][0];
        int cnt = 0;
        while(true) {
            if (now >= N-1) break;
            if (dp[0][now] == -1 && dp[1][now] == -1) {
                if (arr[now] == 0) break;
                now += arr[now];
                cnt++;
                continue;
            }
            ans = Math.max(ans, cnt + dp[1][now]);
            if (arr[now] == 0) break;
            now += arr[now];
            cnt++;
        }
        System.out.println(ans);
    }
}