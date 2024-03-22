import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 17:15 ~
public class Main {
    private static class Cable implements Comparable<Cable> {
        int u, v, w;
        Cable(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Cable c) {
            return this.w - c.w;
        }
    }
    private static int N;
    private static Set<Integer> baljeon;
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        baljeon = new TreeSet<>(); // 해당 노드가 발전소인지 확인
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++) baljeon.add(Integer.parseInt(st.nextToken()));
        PriorityQueue<Cable> queue = new PriorityQueue<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            queue.add(new Cable(u, v, w));
        }
        parents = new int[N+1];
        for(int i=0;i<=N;i++) parents[i] = i;
        int answer = 0;
        while(!queue.isEmpty()) {
            Cable now = queue.poll();
            if (union(now.u, now.v)) answer += now.w;
        }
//        System.out.println(Arrays.toString(parents));
        System.out.println(answer);

    }
    private static int findset(int x) {
        if (baljeon.contains(x)) return x; // 만약 해당 노드가 발전소면 그냥 발전소 리턴
        else if (parents[x] == x) return x; // 그게 아니라면 루트 리턴
        else return parents[x] = findset(parents[x]); // 아니면 그냥 계속 타고가기
    }
    private static boolean union(int x, int y) {
        int rx = findset(x);
        int ry = findset(y);
        if (rx == ry || (baljeon.contains(rx) && baljeon.contains(ry))) return false; // 이미 같은 집합이거나 둘다 발전소면 안합침
        else if(baljeon.contains(rx)) {
            parents[ry] = rx;
        } else if (baljeon.contains(ry)) {
            parents[rx] = ry;
        } else if (rx < ry) {
            parents[ry] = rx;
        } else parents[rx] = ry;
        return true;
    }
}