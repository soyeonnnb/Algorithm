import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer>[] flist = new List[N+1];
        List<Integer>[] elist = new List[N+1];
        for(int i=0;i<=N;i++) {
            flist[i] = new ArrayList<>();
            elist[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char order = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if (order == 'F') {
                flist[p].add(q);
                flist[q].add(p);
            } else {
                elist[p].add(q);
                elist[q].add(p);
            }
        }
        int ans = 0;
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++) {
            if (visited[i]) continue;
            ans++;
            visited[i] = true;
            queue.clear();
            queue.add(i);
            while(!queue.isEmpty()) {
                int now = queue.poll();
                // 내 친구
                for(int nxt : flist[now]) {
                    if (visited[nxt]) continue;
                    queue.add(nxt);
                    visited[nxt] = true;
                }
                // 원수
                for(int prev : elist[now]) {
                    // 원수의 원수
                    for(int nxt : elist[prev]) {
                        if (visited[nxt]) continue;
                        queue.add(nxt);
                        visited[nxt] = true;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}