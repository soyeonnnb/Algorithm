import javax.print.attribute.standard.PrinterResolution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 12:56 ~
public class Main {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        parent = new int[2 * N+1];
        for(int i=0;i<=2 * N;i++) parent[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int p3 = Integer.parseInt(st.nextToken());
            int p4 = Integer.parseInt(st.nextToken());
            pq.add(new int[]{c, p1, p3});
            union(p1, p2);
            union(p3, p4);
        }
        int ans = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if (union(now[1], now[2])) ans += now[0];
        }
        System.out.println(ans);
    }
    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    private static boolean union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        if (xr == yr) return false;
        parent[yr] = xr;
        return true;
    }
}