import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent, dots;
    private static PriorityQueue<int[]> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int Q=Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        dots = new int[N+1];
        for(int i=0;i<=N;i++) parent[i] = i;
        Arrays.fill(dots, 1);
        pq = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);
        for(int i=1;i<=N;i++) pq.add(new int[]{i, 1});
        StringBuilder sb = new StringBuilder();
        for(int q=0;q<Q;q++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if (order == 1) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                union(u, v);
                continue;
            }
//            System.out.println(Arrays.toString(dots));
            while(dots[pq.peek()[0]] != pq.peek()[1]) pq.poll();
            int[] now = pq.poll();
            sb.append(now[0]).append("\n");
            dots[now[0]] = -1;
        }
        System.out.println(sb);
    }
    private static int findset(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = findset(parent[x]);
    }
    private static boolean union(int x, int y) {
        int xr = findset(x);
        int yr = findset(y);
        if (xr == yr) {
            dots[xr] = -1;
            return false;
        }
        else if (dots[xr] == -1 || dots[yr] == -1) {
            dots[xr] = -1;
            dots[yr] = -1;
            return false;
        }
        if (xr < yr) {
            parent[yr] = xr;
            dots[xr] += dots[yr];
            dots[yr] = -1;
            pq.add(new int[]{xr, dots[xr]});
        } else {
            parent[xr] = yr;
            dots[yr] += dots[xr];
            dots[xr] = -1;
            pq.add(new int[]{yr, dots[yr]});
        }
        return true;
    }
}