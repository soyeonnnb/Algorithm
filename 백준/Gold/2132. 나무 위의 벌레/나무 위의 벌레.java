import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 14:49 ~
public class Main {
    private static int ans, max;
    private static int[] arr;
    private static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u =Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        ans = 1;
        max = 0;
        dfs(1, 0, arr[1]);
        int temp = ans;
        ans = 1;
        max = 0;
        dfs(temp, 0, arr[temp]);
        System.out.println(max+" "+Math.min(ans, temp));
    }
    private static void dfs(int cur, int prv, int score) {
        if (max == score) {
            ans = Math.min(ans, cur);
        } else if (max < score) {
            ans = cur;
            max = score;
        }
        for(int nxt : list[cur]) {
            if (nxt == prv) continue;
            dfs(nxt, cur, score+arr[nxt]);
        }
    }
}