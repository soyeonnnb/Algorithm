import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer>[] list;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        list = new List[N+1];
        for(int i=1;i<=N;i++) list[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=2;i<=N;i++) {
            Integer n = Integer.parseInt(st.nextToken());
            list[n].add(i);
        }

        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());

        // 0은 해당 수 포함 안된거, 1은 해당 수 포함 된거
        dp = new int[N+1][2];
        for(int i=0;i<=N;i++) Arrays.fill(dp[i], -1);
        System.out.println(Math.max(recur(1, 0), recur(1, 1)));
    }

    private static int recur(int cur, int include) {
        if (dp[cur][include] != -1) return dp[cur][include];

        dp[cur][include] = 0;

        if (include == 0) { // 포함 안하면 내 멘티중에서 포함한거/안한거 중에 최댓값 그냥 더하기
            for(int nxt : list[cur]) {
                dp[cur][include] += Math.max(recur(nxt, 0), recur(nxt, 1));
            }
        } else {
            int sum = 0; // 먼저 포함 안한거 가져다가 계산
            for(int nxt : list[cur]) sum += Math.max(recur(nxt, 0), recur(nxt, 1));
            int result = sum;
            for(int nxt : list[cur]) {
                int now = Math.max(recur(nxt, 0), recur(nxt, 1)) - recur(nxt, 0) - arr[nxt] * arr[cur];
                result = Math.max(result, sum - now);
            }
            dp[cur][include] = result;
        }

        return dp[cur][include];

    }
}