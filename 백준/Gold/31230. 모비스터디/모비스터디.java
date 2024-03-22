import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 22:07 ~
public class Main {
    private static class Edge {
        int dest, w;
        Edge(int dest, int w) {
            this.dest = dest;
            this.w = w;
        }
    }
    private static class Node implements Comparable<Node> {
        int num;
        long weight;
        Node(int num, long weight) {
            this.num = num;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node n) {
            return this.weight < n.weight ? -1 : 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        long[] arr = new long[N+1];
        long[] brr = new long[N+1];
        Arrays.fill(arr, 60000000000L);
        Arrays.fill(brr, 60000000000L);
        List<Edge>[] list = new ArrayList[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
            list[v].add(new Edge(u, w));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        dijkstra(arr, N, A, B, list, pq, visited);
        dijkstra(brr, N, B, A, list, pq, visited);
        StringBuilder sb = new StringBuilder();
        int size = 0;
        for(int i=1;i<=N;i++) {
            if (arr[i] + brr[i] == arr[B]) {
                sb.append(i+" ");
                size++;
            }
        }
        System.out.println(size);
        System.out.println(sb);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(brr));
    }
    private static void dijkstra(long[] arr, int N, int start, int finish, List<Edge>[] list, PriorityQueue<Node> pq, boolean[] visited) {
        pq.clear();
        Arrays.fill(visited, false);
        pq.add(new Node(start, 0L));
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.num]) continue;
            arr[now.num] = now.weight;
            visited[now.num] = true;
            if (now.num == finish) return;
            for(Edge e : list[now.num]) {
                if (visited[e.dest]) continue;
                pq.add(new Node(e.dest, now.weight + e.w));
            }
        }
    }
}