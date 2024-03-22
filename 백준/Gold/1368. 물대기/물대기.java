import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 12:18 ~
public class Main {
    private static class Node implements Comparable<Node>{
        int u, v, w;
        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Node n) {
            return this.w - n.w;
        }
    }
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) pq.add(new Node(i, i, Integer.parseInt(br.readLine())));
        StringTokenizer st;
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        boolean[] visited = new boolean[N];
        parents = new int[N];
        for(int i=0;i<N;i++) parents[i] = i;
        int answer = 0 ;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            // 같은 집단이면 이미 연결된거라서 안해도 됨
            if (now.u == now.v) {
                if (visited[now.v]) continue;
                visited[now.v] = true;
                answer += now.w;
                for(int i=0;i<N;i++) {
                    if (i == now.v || visited[i]) continue;
                    pq.add(new Node(now.v, i, arr[now.v][i]));
                }
                continue;
            }
            if (visited[now.v] || !union(now.u, now.v)) {
                continue; // 이미 같은 집단이면 필요없음
            }
            visited[now.v] = true;
            answer += now.w;
            for(int i=0;i<N;i++) {
                if (i == now.v || visited[i]) continue;
                pq.add(new Node(now.v, i, arr[now.v][i]));
            }
        }
        System.out.println(answer);
    }
    private static int findset(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = findset(parents[x]);
    }
    private static boolean union(int x, int y) {
        int rx = findset(x);
        int ry = findset(y);
        if (rx == ry) {
            return false;
        }
        else if (rx < ry) parents[ry] = rx;
        else parents[rx] = ry;
        return true;
    }
}