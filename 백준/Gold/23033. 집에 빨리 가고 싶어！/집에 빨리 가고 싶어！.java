import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node {
        int dest, t, w;
        Node(int dest, int t, int w) {
            this.dest = dest;
            this.t = t;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        List<Node>[] list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, t, w));
        }
        boolean[] visited = new boolean[N+1];
        int[] weights = new int[N+1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        weights[1] = 0;
        int ans = 0;
        while(!set.isEmpty()) {
            // 가장 짧은 애부터 확인
            int idx = -1;
            int tookTime = Integer.MAX_VALUE;
            for(Integer nxt : set) {
                if (weights[nxt] <= tookTime) {
                    idx = nxt;
                    tookTime = weights[nxt];
                }
            }
            if (idx == -1) break;

            set.remove(idx);
            visited[idx] = true;
            if (idx == N) { // 정답이면 종료
                ans = tookTime;
                break;
            }

            for(Node nxt : list[idx]) {
                if (visited[nxt.dest]) continue; // 이미 방문했으면
                set.add(nxt.dest); // set에 추가
                int arriveTime = tookTime%nxt.w == 0 ? 0 : nxt.w - tookTime%nxt.w; // 출발까지 기다려야하는 시간
                arriveTime += tookTime + nxt.t;
                if (weights[nxt.dest] >= arriveTime) weights[nxt.dest] = arriveTime;

            }
        }
        System.out.println(ans);
    }


}