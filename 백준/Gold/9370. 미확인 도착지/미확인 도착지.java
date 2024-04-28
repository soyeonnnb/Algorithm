import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 17:00 ~
public class Main {
    private static List<int[]>[] list;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=TC;tc++) {
            st = new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            int T=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int g=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            int gToH = 0;
            list = new List[N+1];
            for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int u=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());
                int w=Integer.parseInt(st.nextToken());
                list[u].add(new int[]{v, w});
                list[v].add(new int[]{u, w});
                if ((u == g && v == h) || (v == g && u == h)) gToH = w;
            }
            List<Integer> dest = new ArrayList<>();
            for(int i=0;i<T;i++) dest.add(Integer.parseInt(br.readLine()));
            int[][] dij = new int[3][];
            dij[0] = dijstra(s);
            dij[1] = dijstra(g);
            dij[2] = dijstra(h);
            List<Integer> ans = new ArrayList<>();
            for(int d : dest) {
                int min = -1;
                if (dij[0][g] != -1 && dij[2][d] != -1) min = dij[0][g] + gToH + dij[2][d];
                if (dij[0][h] != -1 && dij[1][d] != -1) min = min == -1 ? dij[0][h] + gToH + dij[1][d]: Math.min(min, dij[0][h] + gToH + dij[1][d]);
                if (min != -1 && min == dij[0][d]) ans.add(d);
            }
            ans.sort(Comparator.naturalOrder());
            for(int num : ans) sb.append(num).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static int[] dijstra(int start) {
        int[] dij = new int[N+1];
        Arrays.fill(dij, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if (dij[now[0]] != -1) continue;
            dij[now[0]] = now[1];
            for(int[] nxt : list[now[0]]) {
                if (dij[nxt[0]] != -1) continue;
                pq.add(new int[]{nxt[0], now[1] + nxt[1]});
            }
        }

        return dij;
    }
}