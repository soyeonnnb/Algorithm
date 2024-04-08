import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 12:25 ~
public class Main {
    private static List<Integer>[] list;
    private static int[] sub, depth, weight, claw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        weight = new int[N+1];
        StringTokenizer st;
        boolean[] isRoot = new boolean[N+1];
        Arrays.fill(isRoot, true);
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[v].add(u);
            weight[u] = w;
            isRoot[u] = false;
        }
        int root = 0;
        for(int i=1;i<=N;i++) if (isRoot[i]) root = i;
        sub = new int[N+1]; // 서브트리 크기
        depth = new int[N+1]; // 루트까지의 거리
        claw = new int[N+1]; // claw 계산
        dfs(root);
        for(int i=1;i<=N;i++) claw[i] = sub[i] + depth[i];
        dfs2(root);
        int ans = 0;
        for(int i=1;i<=N;i++) {
            ans = Math.max(ans, claw[i]);
        }
        System.out.println(ans);
    }
    private static void dfs(int cur) {
        for(int nxt : list[cur]) {
            depth[nxt] = depth[cur] + weight[nxt];
            dfs(nxt);
            sub[cur] += sub[nxt] + weight[nxt];
        }
    }
    private static void dfs2(int cur) {
        for(int nxt: list[cur]) {
            claw[nxt] += claw[cur];
            dfs2(nxt);
        }
    }
}