import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

// 12:15 ~
public class Main {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0;i<=N;i++) parent[i]=i;
        StringBuilder sb = new StringBuilder();
        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (query == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) sb.append("YES");
                else sb.append("NO");
                sb.append("\n");
            }
        }
        System.out.println(sb);
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