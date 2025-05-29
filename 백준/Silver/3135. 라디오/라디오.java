
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[1001];
        Arrays.fill(visited, -1);
        visited[A] = 0;
        queue.add(A);
        for(int i=0;i<N;i++) {
            Integer n = Integer.parseInt(br.readLine());
            if (n == A) continue;
            queue.add(n);
            visited[n] = 1;
        }
        while(visited[B] == -1) {
            int now = queue.poll();
            if (now-1 >=0 && visited[now-1] == -1) {
                visited[now-1] = visited[now] + 1;
                queue.add(now-1);
            }
            if (now+1 <= 1000 && visited[now+1] == -1) {
                visited[now+1] = visited[now] + 1;
                queue.add(now+1);
            }
        }
        System.out.println(visited[B]);
    }
}
