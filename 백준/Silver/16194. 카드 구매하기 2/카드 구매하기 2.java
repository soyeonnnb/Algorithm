
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];
        Arrays.fill(dp, arr[1] * N);
        for(int i=1;i<=N;i++) dp[i] = arr[i];
        for(int i=2;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if (i < j) continue;
                dp[i] = Math.min(dp[i], dp[i-j] + arr[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
