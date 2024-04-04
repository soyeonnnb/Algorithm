import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 12:57 ~
public class Main {
    private static List<Integer>[] list;
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        list = new List[N+1];
        for (int i=0;i<=N;i++) list[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        parents = new int[N+1];
        dfs(1, 0);
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++) sb.append(parents[i]).append("\n");
        System.out.println(sb);
    }
    private static void dfs(int cur, int prv) {
        for(int num : list[cur]) {
            if (num == prv) continue;
            dfs(num, cur);
            parents[num] = cur;
        }
    }
}