import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 14:25 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] dp = new int[b+1][2];
        for(int i=0;i<=b;i++) Arrays.fill(dp[i], -1);
        dp[a][0] = 0;
        // 현재 수
        for(int i=a+1;i<=b;i++) {
            // 물주기
            dp[i][0] = dp[i-1][0] + 1;
            // 만약 이전에 chance를 외친 적이 있다면
            if (dp[i-1][1] != -1) dp[i][1] = dp[i-1][1] + 1;

            // 만약 밥을 줄 수 있다면
            if(i%2 == 0 && dp[i/2][0] != -1) {
                dp[i][0] = Math.min(dp[i][0], dp[i/2][0] + 1);
                if (dp[i/2][1] != -1) dp[i][1] = dp[i][1] == -1 ? dp[i/2][1]+1 : Math.min(dp[i][1], dp[i/2][1] + 1);
            }

            // 만약 chance를 외칠 수 있다면
            if (i%10 == 0 && dp[i/10][0] != -1) {
                dp[i][1] = dp[i][1] == -1 ? dp[i/10][0] + 1 : Math.min(dp[i][1], dp[i/10][0] + 1);
            }
        }
        int ans = 0;
        if (dp[b][0] != -1 && dp[b][1] != -1) ans = Math.min(dp[b][0], dp[b][1]);
        else ans = Math.max(dp[b][0], dp[b][1]);
        System.out.println(ans);
    }
}