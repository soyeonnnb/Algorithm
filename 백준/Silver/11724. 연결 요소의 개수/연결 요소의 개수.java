import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12:20
public class Main {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1;i<=N;i++) parent[i] = i;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int ans = 0;
        for(int i=1;i<=N;i++) if (parent[i] == i) ans++;
        System.out.println(ans);
    }
    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    private static void union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        if (xr == yr) return;
        parent[yr] = xr;
    }
}