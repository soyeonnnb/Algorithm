import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 13:14 ~
public class Main {
    private static List<int[]>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list[u].add(new int[]{v, w});
            list[v].add(new int[]{u, w});
        }
        int[] res = bfs(1);
        int[] ans = bfs(res[0]);
        System.out.println(ans[1]);

    }
    private static int[] bfs(int start) {
        int[] ans = new int[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 나, 가중치, 부모
        pq.add(new int[]{start, 0, 0});
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[1] > ans[1]) {
                ans[1] = now[1];
                ans[0] = now[0];
            }
            for(int[] nxt : list[now[0]]) {
                if (nxt[0] == now[2]) continue;
                pq.add(new int[]{nxt[0], nxt[1] + now[1], now[0]});
            }
        }
        return ans;
    }
}