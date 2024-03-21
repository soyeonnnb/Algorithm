import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// DFS로 풀자 !!!
public class Main {
    private static int answer, N, b;
    private static int[] visited;
    private static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new int[N+1];
        Arrays.fill(visited, -1);
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        int M=Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            list[i1].add(i2);
            list[i2].add(i1);
        }
        visited[a] = 0;
        dfs(a, 0);
        System.out.println(visited[b]);
    }
    private static void dfs(int cur, int now) {
        if (cur == b) return;
        for(int x : list[cur]) {
            if (visited[x] == -1 || visited[x] > now) {
                visited[x] = now+1;
                dfs(x, now+1);
            }
        }
    }
}