import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 22:42 ~
public class Main {
    private static int N;
    private static final int MOD = 1000000007;
    private static int[] sz;
    private static List<Integer>[] list;
    private static List<Long> lengths;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        list = new List[N+1];
        sz = new int[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        int[] arr = new int[N-1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        lengths = new ArrayList<>();
        dfs(1, 0);
//        System.out.println(Arrays.toString(sz));
        lengths.sort(Comparator.reverseOrder());
//        System.out.println(Arrays.toString(arr));
//        System.out.println(lengths);
        long ans = 0;
        for(int i=0;i<N-1;i++) {
            ans += arr[i] * lengths.get(i);
            ans %= MOD;
        }
        System.out.println(ans);
    }

    private static void dfs(int cur, int prv) {
        for(int nxt : list[cur]) {
            if (nxt == prv) continue;
            dfs(nxt, cur);
            sz[cur] += sz[nxt];
        }
        sz[cur]++;
        if (cur != 1)
            lengths.add(((long) sz[cur] * (N-sz[cur])));
    }
}