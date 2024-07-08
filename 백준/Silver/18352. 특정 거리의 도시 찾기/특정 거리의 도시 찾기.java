import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken()) + 1;
        int X=Integer.parseInt(st.nextToken());
        List<Integer>[] list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }
        int[] visited = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        visited[X] = 1;
        int length = 1;
        while(!queue.isEmpty() && length < K) {
            int sz = queue.size();
            length++;
            for(int s=0;s<sz;s++) {
                int now = queue.poll();
                for(int nxt : list[now]) {
                    if (visited[nxt] != 0) continue;
                    visited[nxt] = length;
                    queue.add(nxt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            if (visited[i] != K) continue;
            sb.append(i).append("\n");
        }
        if (sb.length() == 0) System.out.println(-1);
        else System.out.println(sb);
    }
}