import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

// 15:42 ~
public class Main {
    private static class SetNode {
        boolean visited;
        Set<Integer> set;
        public SetNode() {
            this.set = new HashSet<>();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        List<SetNode>[] list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            SetNode set = new SetNode();
            for(int j=0;j<K;j++) set.set.add(Integer.parseInt(st.nextToken()));
            for(Integer num : set.set) list[num].add(set);
        }
        int[] visited = new int[N+1];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 1;
        outer: while(!queue.isEmpty()) {
            int now = queue.poll();
            for(SetNode nxtSet : list[now]) {
                if (nxtSet.visited) continue;
                nxtSet.visited = true;
                for(Integer nxt : nxtSet.set) {
                    if (visited[nxt] != -1) continue;
                    queue.add(nxt);
                    visited[nxt] = visited[now] + 1;
                    if (nxt == N) break outer;
                }
            }
        }
        System.out.println(visited[N]);
    }
}