import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[N+1][3];
        dp[1][1] = arr[1];
        if (N >= 2) {
            dp[2][0] = arr[1];
            dp[2][1] = arr[2];
            dp[2][2] = arr[1] + arr[2]/2;
        }
        for(int i=3;i<=N;i++) {
            // 안먹는 경우
            dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
            // 첫번째로 먹는 경우
            dp[i][1] = dp[i-1][0] + arr[i];
            // 두번째로 먹는 경우
            dp[i][2] = dp[i-1][1] + arr[i]/2;
        }
        System.out.println(Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]));
    }
}
