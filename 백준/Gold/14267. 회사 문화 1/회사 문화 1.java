import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 17:43 ~
public class Main {
    private static int[] praise;
    private static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i=2;i<=N;i++) {
            int p = Integer.parseInt(st.nextToken());
            list[p].add(i);
        }
        praise = new int[N+1];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            praise[a] += b;
        }
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) sb.append(praise[i]).append(" ");
        System.out.println(sb);
    }
    private static void dfs(int cur) {
        for(int nxt : list[cur]) {
            praise[nxt] += praise[cur];
            dfs(nxt);
        }
    }

}