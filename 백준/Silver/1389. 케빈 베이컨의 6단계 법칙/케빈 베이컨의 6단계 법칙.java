import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 02:15 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        Set<Integer>[] list = new TreeSet[N+1];
        for(int i=0;i<=N;i++) list[i] = new TreeSet<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        int ans = 0;
        int sum = N*N;
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            queue.clear();
            queue.add(i);
            int result = 0;
            int length = 0;
            while(!queue.isEmpty()) {
                int sz = queue.size();
                length++;
                for(int s=0;s<sz;s++) {
                    int now = queue.poll();
                    for(Integer nxt : list[now]) {
                        if (visited[nxt]) continue;
                        result += length;
                        visited[nxt] = true;
                        queue.add(nxt);
                    }
                }
            }
            if (result < sum) {
                sum = result;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
