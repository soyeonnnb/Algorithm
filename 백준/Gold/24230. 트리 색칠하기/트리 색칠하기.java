import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 23:52 ~
public class Main {
    private static int ans;
    private static int[] arr, parents;
    private static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        ans = arr[1] == 0 ? 0 : 1;
        parents = new int[N+1];
        dfs(1, 0);
        System.out.println(ans);
    }
    private static void dfs(int cur, int prv) {
        for(int nxt : list[cur]) {
            if(nxt == prv) continue;
            parents[nxt] = cur;
            if (arr[nxt] != arr[cur]) ans++;
            dfs(nxt, cur);
        }
    }
}