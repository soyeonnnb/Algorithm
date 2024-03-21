import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 21:49 ~
// DFS로 풀어보자 !
public class Main {
    private static int N, M, cost;
    private static int[] arr;
    private static boolean[] visited;
    private static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        visited = new boolean[N+1];
        int total = 0;
        for(int i=1;i<=N;i++) {
            if (visited[i]) continue;
            cost = arr[i];
            dfs(i);
            total += cost;
        }
        if (total > k) System.out.println("Oh no");
        else System.out.println(total);
    }
    private static void dfs(int now) {
        visited[now] = true;
        cost = Math.min(cost, arr[now]);
        for(int num : list[now]) {
            if (visited[num]) continue;
            dfs(num);
        }
    }
}