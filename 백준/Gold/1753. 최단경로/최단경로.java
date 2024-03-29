import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 19:29 ~
public class Main {
    private static class Node implements Comparable<Node>{
        int dest, weight;
        Node (int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(br.readLine());
        List<Node>[] list = new ArrayList[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        int[] arr = new int[N+1];
        Arrays.fill(arr, -1);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if (arr[now.dest] != -1) continue;
            arr[now.dest] = now.weight;
            for(Node node : list[now.dest]) {
                if (arr[node.dest] != -1) continue;
                pq.add(new Node(node.dest, now.weight + node.weight));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            sb.append(arr[i] == -1 ? "INF":arr[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}