import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 13:37 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int t=Integer.parseInt(st.nextToken());
        List<int[]>[] list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new int[]{v, w});
            list[v].add(new int[]{u, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for(int[] nxt : list[1]) pq.add(nxt);
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        int connected = 0;
        long ans = 0;
        while(!pq.isEmpty() && connected != N-1) {
            int[] now = pq.poll();
            if (visited[now[0]]) continue;
            ans += now[1] +  t * connected;
            connected++;
            visited[now[0]] = true;
            for(int[] nxt : list[now[0]]) {
                if (visited[nxt[0]]) continue;
                pq.add(nxt);
            }
        }
        System.out.println(ans);
    }
}