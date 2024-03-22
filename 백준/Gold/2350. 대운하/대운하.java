import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 17:34 ~
public class Main {
    private static class Edge implements Comparable<Edge>{
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge e) {
            return e.w - this.w;
        }
    }
    private static class Destination implements Comparable<Destination> {
        int dest, w;
        Destination(int dest, int w) {
            this.dest = dest;
            this.w = w;
        }
        @Override
        public int compareTo(Destination e) {
            return e.w - this.w;
        }
    }
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        List<Destination>[] list = new ArrayList[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            queue.add(new Edge(u, v, w));
        }
        parents = new int[N+1];
        for(int i=0;i<=N;i++) parents[i] = i;
        int connected = 0;
        // edge 를 N-1개로 줄여줌
        while(connected != N-1) {
            Edge now = queue.poll();
            if (union(now.u, now.v)) {
                connected++;
                list[now.u].add(new Destination(now.v, now.w));
                list[now.v].add(new Destination(now.u, now.w));
            }
        }
        PriorityQueue<Destination> destQueue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[N+1];
        for(int k=1;k<=K;k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Arrays.fill(visited, false);
            destQueue.clear();
            visited[a] = true;
            int answer = Integer.MAX_VALUE ;
            for(Destination e : list[a]) destQueue.add(e);
            while(!destQueue.isEmpty()) {
                Destination now = destQueue.poll();
                answer = Math.min(answer, now.w);
                if(now.dest == b) break;
                visited[now.dest] = true;
                for(Destination e : list[now.dest]) {
                    if (visited[e.dest]) continue;
                    destQueue.add(e);
                }
            }
            System.out.println(answer);
        }
        System.out.println(sb);
    }
    private static int findset(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = findset(parents[x]);
    }
    private static boolean union(int x, int y) {
        int rx = findset(x);
        int ry = findset(y);
        if (rx == ry) return false;
        else if (rx < ry) parents[ry] =rx;
        else parents[rx] = ry;
        return true;
    }
}