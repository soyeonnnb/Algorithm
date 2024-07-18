import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[][] dp = new int[2][2];
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) dp[i][j] = -1001;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1001;
        for(int i=1;i<=N;i++) {
            int num = Integer.parseInt(st.nextToken());

            // 그냥 해당 수를 더하는 경우
            dp[i%2][0] = Math.max(dp[(i+1)%2][0] + num, num);
            dp[i%2][1] = Math.max(dp[(i+1)%2][1] + num, dp[(i+1)%2][0]);
            max = Math.max(dp[i%2][0], max);
            max = Math.max(dp[i%2][1], max);
        }

        System.out.println(max);
    }
}