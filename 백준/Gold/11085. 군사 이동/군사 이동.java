import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        parent = new int[N];
        for(int i=0;i<N;i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int C=Integer.parseInt(st.nextToken());
        int V=Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);


        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            pq.add(new int[]{u, v, w});
        }

        int ans = 0;
        while(!pq.isEmpty() && findset(C) != findset(V)) {
            int[] now = pq.poll();
            ans = now[2];
            union(now[0], now[1]);
        }
        System.out.println(ans);

    }

    private static int findset(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = findset(parent[x]);
    }
    private static boolean union(int x, int y){
        int xr = findset(x);
        int yr = findset(y);
        if (xr == yr) return false;
        parent[yr] = xr;
        return true;
    }

}