import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 19:29 ~
// dfs로 풀기 !
public class Main {
    private static class Node {
        int dest, weight;
        Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    private static int N, a, b;
    private static List<Node>[] list;
    private static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[i1].add(new Node(i2, weight));
            list[i2].add(new Node(i1, weight));
        }
        visited = new int[N+1][2];
        for(int i=0;i<=N;i++) for(int j=0;j<2;j++) visited[i][j] = -1;
        visited[a][0] = 0;
        dfs(a, 0, 0);
        visited[b][1] = 0;
        dfs(b, 0, 1);
        int answer = 2000000000;
        for(int i=1;i<=N;i++) {
            for(Node n : list[i]) {
                answer = Math.min(answer, Math.min(visited[i][1] + visited[n.dest][0], visited[i][0] + visited[n.dest][1]));
            }
        }
        if (a == b) System.out.println(0);
        else System.out.println(answer);
    }
    private static void dfs(int now, int weight, int idx) {
        for(Node node : list[now]) {
            if (visited[node.dest][idx] != -1  && visited[node.dest][idx] < weight + node.weight) continue;
            visited[node.dest][idx] = weight + node.weight;
            dfs(node.dest, weight + node.weight, idx);
        }
    }
}