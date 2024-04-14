import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 11:41 ~
public class Main {
    private static int[] parent;
    private static List<Integer>[] list;
    private static boolean cycle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc=1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            list = new List[N+1];
            for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
            parent = new int[N+1];
            for(int i=0;i<=N;i++) parent[i] = i;
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            int ans = 0;
            for(int i=1;i<=N;i++) {
                if (parent[i] != i) continue; // 이미 하나의 연결요소에 포함됨
                cycle = false;
                dfs(i, 0);
                if (!cycle) ans++;
            }
            sb.append("Case ").append(tc).append(": ");
            if(ans == 0) sb.append("No trees.");
            else if (ans == 1) sb.append("There is one tree.");
            else sb.append("A forest of ").append(ans).append(" trees.");
            sb.append("\n");
            tc++;
        }
        System.out.println(sb);
    }

    private static void dfs(int cur, int prv) {
        for(int nxt : list[cur]) {
            if (nxt == prv) continue;
            if (!union(cur, nxt)) {
                cycle = true;
            } else {
                dfs(nxt, cur);
            }
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    private static boolean union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        if (xr == yr) return false;
        parent[yr] = xr;
        return true;
    }
}
