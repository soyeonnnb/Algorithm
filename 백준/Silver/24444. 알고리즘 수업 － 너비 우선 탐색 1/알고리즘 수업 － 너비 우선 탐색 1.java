
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
        int R=Integer.parseInt(st.nextToken());
        List<Integer>[] list = new List[N+1];
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            list[A].add(B);
            list[B].add(A);
        }
        for(int i=0;i<=N;i++) list[i].sort(Comparator.naturalOrder());
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        int now = 1;
        int[] visited = new int[N+1];
        Arrays.fill(visited, -2);
        while(!queue.isEmpty()) {
            int pop = queue.poll();
            visited[pop] = now++;
            for(int n : list[pop]) {
                if (visited[n] != -2) continue;
                visited[n] = -1;
                queue.add(n);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            if (visited[i] == -2) sb.append(0).append("\n");
            else sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
}
