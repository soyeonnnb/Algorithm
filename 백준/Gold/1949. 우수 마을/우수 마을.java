import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] arr;
    private static List<Integer>[] list;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        // 밑에 우수마을 까지의 거리. 0이면 해당 노드가 우수마을. 1은 그 전에 우수마을이 하나라도 있. 2는 그 전전이 우수마을
        dp = new int[N+1][3];
        dfs(1, 0);
//        for(int i=1;i<=N;i++) System.out.println(Arrays.toString(dp[i]));
        int ans = 0;
        for(int i=0;i<2;i++) ans = Math.max(ans, dp[1][i]);
        System.out.println(ans);
    }
    private static void dfs(int cur, int prv) {
        int mind = 100000000;
        int maxd = -100000000;
        for(int nxt : list[cur]) {
            if(nxt == prv) continue;
            dfs(nxt, cur);
            dp[cur][0] += Math.max(dp[nxt][1], dp[nxt][2]);
//            dp[cur][1] += dp[nxt][0];
//            if (max < dp[nxt][0]) {
//                max = dp[nxt][0];
//                idx = nxt;
//            }
            dp[cur][1] += Math.max(dp[nxt][0], dp[nxt][1]);
            mind = Math.min(mind, dp[nxt][0] - dp[nxt][1]);
            maxd = Math.max(maxd, dp[nxt][0] - dp[nxt][1]);
            dp[cur][2] += dp[nxt][1]; // 그 전에 우수마을이 하나도 없을때
//            pq.add(new int[]{});
        }
        dp[cur][0] += arr[cur];
//        System.out.println(mind+" "+maxd);
        if (maxd <= 0) dp[cur][1] += maxd;
    }
}
