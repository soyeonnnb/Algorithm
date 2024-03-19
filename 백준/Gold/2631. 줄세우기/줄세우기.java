import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i=2;i<=N;i++) {
            int max = 0;
            for(int j=1;j<i;j++) {
                if (arr[i] > arr[j]) max = Math.max(max, dp[j]);
            }
            dp[i] = max+1;
        }
        int ans = 0;
        for(int i=1;i<=N;i++) ans = Math.max(ans, dp[i]);
        System.out.println(N-ans);
    }
}