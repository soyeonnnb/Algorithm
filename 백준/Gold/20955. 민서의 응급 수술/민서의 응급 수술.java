import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 18:25 ~
public class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i=0;i<=N;i++) parents[i] = i;
        int ans = 0;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (!union(u, v)) ans++;
        }
        for(int i=2;i<=N;i++) {
            if (union(1, i)) ans++;
        }
        System.out.println(ans);

    }
    private static int findset(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = findset(parents[x]);
    }

    private static boolean union(int x, int y) {
        int xr = findset(x);
        int yr = findset(y);
        if (xr == yr) return false;

        parents[yr] = xr;
        return true;
    }
}