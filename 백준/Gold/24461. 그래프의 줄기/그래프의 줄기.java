import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 19:19 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        List<Integer>[] list = new List[N];
        for(int i=0;i<N;i++) list[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        int[] linked = new int[N];
        int[] nodes = new int[N];
        int maxIdx = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] removed = new boolean[N];

        for(int i=0;i<N;i++) {
            int n = list[i].size(); // 현재 i와 연결된 노드 개수
            linked[i] = n; // 현재 i와 연결된 노드 개수
            nodes[n]++; // n개 연결된 노드의 개수
            maxIdx = Math.max(maxIdx, n); // 연결된 노드의 최대 개수
        }

        StringBuilder sb = new StringBuilder();
        if (maxIdx <= 2) { // 만약 최대 2개 연결 == 한줄로 이어짐
            for(int i=0;i<N;i++) sb.append(i).append(" ");
            System.out.println(sb);
            return;
        }

        for(int i=0;i<N;i++) {
            if (list[i].size() == 1) { // 만약 첫번째로 연결된거라면..
                queue.add(i); // 일단 큐에 저장
            }
        }

        while(!queue.isEmpty() && maxIdx > 2) {
            int sz = queue.size();
            // 하나의 턴으로 이루어짐
            for(int i=0;i<sz;i++) {
                int now = queue.poll(); // 이제 삭제할 노드
                removed[now] = true;
                for(int nxt : list[now]) {
                    if (removed[nxt]) continue;

                    nodes[linked[nxt]]--;
                    linked[nxt]--;// 연결된거 --;
                    nodes[linked[nxt]]++;

                    if (nodes[maxIdx] == 0) {
                        while(maxIdx > 0 && nodes[maxIdx] == 0) maxIdx--;
                    }
                    if (linked[nxt] == 1)
                        queue.add(nxt);
                }
            }
        }

        for(int i=0;i<N;i++) {
            if (!removed[i])
                sb.append(i).append(" ");
        }
        System.out.println(sb);

    }
}