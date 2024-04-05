import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 22:54 ~
public class Main {
    private static List<Integer>[] list;
    private static int[][] dp;
    private static int ans, now;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        ans = N;
        now = 0;
        dp = new int[N+1][2]; // 해당 노드가 얼리어답터일 때 서브노드에서의 얼리 어답터 수 최소값.
        for(int i=1;i<=N;i++) dp[i][1] = 1;
        dfs(1, 0);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    private static void dfs(int cur, int prv) {
        for(int nxt : list[cur]) {
            if (nxt == prv) continue;
            dfs(nxt, cur);
            dp[cur][1] += Math.min(dp[nxt][0], dp[nxt][1]);
            dp[cur][0] += dp[nxt][1];
        }
    }
}