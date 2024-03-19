import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T=Integer.parseInt(st.nextToken());
        int W=Integer.parseInt(st.nextToken());
        int[] arr = new int[T+1];
        for(int i=1;i<=T;i++) arr[i] = Integer.parseInt(br.readLine());
        int[][][] dp = new int[T+1][3][W+1]; // T초에 1/2번에 있는데, W번 움직인거면
        if (arr[1] == 1) dp[1][1][0] = 1;
        else dp[1][2][1] = 1;
        for(int i=2;i<=T;i++) { // i 초에
            for(int j=1;j<=2;j++) { // j 밑에 있을 때
                for(int k=0;k<=W;k++) { // k 번 움직인걸 확인
                    dp[i][j][k] = dp[i-1][j][k] + (arr[i] == j ? 1 : 0); // 안움직임
                    if (k != 0) { // 움직여서 해당 위치로 간거면
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j == 1 ? 2 : 1][k-1] + (arr[i] == j ? 1 : 0));
                    }
                }
            }
        }
        int answer = 0;
        for(int j=1;j<=2;j++) for(int k=0;k<=W;k++) answer = Math.max(answer, dp[T][j][k]);
        System.out.println(answer);

    }
}
