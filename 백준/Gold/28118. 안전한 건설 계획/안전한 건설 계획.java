import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=0;i<=N;i++) parent[i] = i;

        int ans = 0;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }
        for(int i = 2;i<=N;i++) {
            if (union(1, i)) ans++;
        }
        System.out.println(ans);
    }

    private static int findset(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = findset(parent[x]);
    }

    private static boolean union(int x, int y) {
        int xr = findset(x);
        int yr = findset(y);

        if (xr == yr) return false;
        parent[yr] = xr;
        return true;
    }
}