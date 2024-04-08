import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 17:40 ~
public class Main {
    private static int[] parents, red;
    private static int[][] sub;
    private static long[] dp;
    private static int total_blue, total_red;
    private static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        red = new int[N+1];
        dp = new long[N+1];
        total_red = 0;
        total_blue = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            red[i] = Integer.parseInt(st.nextToken());
            if (red[i] == 1) total_red++;
            else total_blue++;
        }
        list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        parents = new int[N+1];
        sub = new int[N+1][2];
        dfs(1, 0);
//        for(int i=1;i<=N;i++) System.out.println(Arrays.toString(sub[i]));
        int M=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int m=0;m<M;m++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(dp[u]).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int cur, int prv) {
        sub[cur][red[cur]]++;
        for(int nxt : list[cur]) {
            if (nxt == prv) continue;
            parents[nxt] = cur;
            dfs(nxt, cur);
            sub[cur][0] += sub[nxt][0];
            sub[cur][1] += sub[nxt][1];
            
            long b = total_blue - sub[nxt][0];
            long r = total_red - sub[nxt][1];
            long b_u = sub[nxt][0];
            long r_u = sub[nxt][1];
            if (red[cur] == 0) b--;
            else r--;
            dp[cur] += b * r_u;
            dp[cur] += r * b_u;
        }
        long b = total_blue - sub[cur][0];
        long r = total_red - sub[cur][1];
        long b_u = sub[cur][0];
        long r_u = sub[cur][1];
        if (red[cur] == 0) b_u--;
        else r_u--;
        dp[cur] += b * r_u;
        dp[cur] += r * b_u;
        dp[cur]/=2;
    }
}