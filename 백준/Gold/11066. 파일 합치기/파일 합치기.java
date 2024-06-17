import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    private static long[][] dp;
    private static int[] prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            N=Integer.parseInt(br.readLine());
            arr = new int[N+1];
            prefix = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
            for(int i=1;i<=N;i++) prefix[i] = arr[i] + prefix[i-1];
            dp = new long[N+1][N+1];
            for(int i=0;i<=N;i++) Arrays.fill(dp[i], -1);
            long ans = Long.MAX_VALUE;
            for(int i=2;i<=N;i++) {
                ans = Math.min(ans, recur(1, i-1) + recur(i, N) + prefix[N] - prefix[0] );
            }
            System.out.println(ans);
        }
    }
    private static long recur(int start, int end) { // IDX ~ 마지막페이지까지 합치는 데에 드는 비용
        if (end < start) return 50000000000L;
        else if (dp[start][end] != -1) return dp[start][end];
        else if (start == end) return dp[start][end] = 0;
        else if (end-start == 1) return dp[start][end] = arr[start] + arr[end];

        long result = Long.MAX_VALUE;
        for(int i=start;i<end;i++) {
            result = Math.min(result, recur(start, i) + recur(i+1, end));
        }

        return dp[start][end] = result + prefix[end] - prefix[start-1];
    }
}