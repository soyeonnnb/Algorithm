import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 19:09 ~
public class Main {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        boolean[] isWomen = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            isWomen[i] = st.nextToken().charAt(0) == 'W';
        }
        parents = new int[N+1];
        for(int i=1;i<=N;i++) parents[i]=i;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (isWomen[u] == isWomen[v]) {
                continue;
            }
            pq.add(new int[]{u, v, w});
        }
        int connected = 0;
        int cost = 0;
        while(!pq.isEmpty() && connected != N-1) {
            int[] now = pq.poll();
            if (union(now[0], now[1])) {
                connected++;
                cost += now[2];
            }
        }
        System.out.println(connected == N-1 ? cost : -1);

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