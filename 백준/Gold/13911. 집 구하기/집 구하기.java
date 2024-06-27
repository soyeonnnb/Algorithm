import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        Map<Integer, Integer>[] map = new Map[N+1];
        for(int i=0;i<=N;i++) map[i] = new HashMap<>();
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            int weight = map[u].getOrDefault(v, 100000);
            weight = Math.min(weight, w);
            map[u].put(v, weight);
            map[v].put(u, weight);
        }
        int[] mac = new int[N+1];
        Arrays.fill(mac, -1);
        int[] star = new int[N+1];
        Arrays.fill(star, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 위치, 거리
        st = new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken()); // 맥도널드 개수
        int x = Integer.parseInt(st.nextToken()); // 맥세권 거리
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            int num = Integer.parseInt(st.nextToken());
            mac[num] = 0;
            for(int key : map[num].keySet()) {
                pq.add(new int[]{key, map[num].get(key)});
            }
        }
        dij(map, pq, mac);
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        pq.clear();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<S;i++) {
            int num = Integer.parseInt(st.nextToken());
            star[num] = 0;
            for(int key : map[num].keySet()) {
                pq.add(new int[]{key, map[num].get(key)});
            }
        }
        dij(map, pq, star);
        int ans = -1;
        for(int i=1;i<=N;i++) {
            if (mac[i] == 0 || star[i] == 0 || mac[i] > x || star[i] > y) continue;
            ans = ans == -1 ? mac[i] + star[i] : Math.min(ans, mac[i] + star[i]);
        }
        System.out.println(ans);
    }
    private static void dij(Map<Integer, Integer>[] map, PriorityQueue<int[]> pq, int[] arr) {
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if (arr[now[0]] != -1) continue;
            arr[now[0]] = now[1];
            for(int nxt : map[now[0]].keySet()) {
                if (arr[nxt] != -1) continue;
                pq.add(new int[]{nxt, now[1] + map[now[0]].get(nxt)});
            }
        }
    }
}