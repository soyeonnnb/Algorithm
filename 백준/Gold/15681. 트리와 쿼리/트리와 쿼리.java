import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 13:03 ~
public class Main {
    private static List<Integer>[] list;
    private static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int R=Integer.parseInt(st.nextToken());
        int Q=Integer.parseInt(st.nextToken());
        list = new List[N+1];
        count = new int[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        dfs(R, 0);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(count[q]).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int cur, int prv) {
        for(int num:list[cur]) {
            if (prv == num) continue;
            dfs(num, cur);
            count[cur] += count[num];
        }
        count[cur]++;
    }
}