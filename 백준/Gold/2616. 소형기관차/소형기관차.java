import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, K;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++) arr[i] += arr[i-1];
        K=Integer.parseInt(br.readLine());
        dp = new int[N+1][4]; // 해당 열차까지 1, 2, 3번째 열차 끄는거 기준
        for(int i=0;i<=N;i++) Arrays.fill(dp[i], -1);
        int ans = 0;
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=3;j++) ans = Math.max(recur(i, j), ans);
        }
//        for(int i=0;i<=N;i++) System.out.println(Arrays.toString(dp[i]));
        System.out.println(recur(N, 3));
    }

    private static int recur(int num, int count) { // num번째 열차를 count번째 기관차가 끌 경우
        if (num < 0) return 0;
        if (dp[num][count] != -1) return dp[num][count];
        if (count == 1) {
            if (num <= K) return dp[num][count] = arr[num];
            else return dp[num][count] = Math.max(arr[num] - arr[num-K], recur(num-1, count));
        }

        dp[num][count] = recur(num-K, count-1) + arr[num];
        if (num-K >= 0) dp[num][count] -= arr[num-K];
        dp[num][count] = Math.max(recur(num-1, count), dp[num][count]);

        return dp[num][count];
    }
}