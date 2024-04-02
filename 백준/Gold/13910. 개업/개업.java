import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 15:22 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int[] visited = new int[N+1];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<M;i++) {
            int input = Integer.parseInt(st.nextToken());
            list.add(input);
            if (visited[input] != -1) continue;
            queue.add(input);
            visited[input] = 1;
        }
        for(int i=0;i<M;i++) {
            for(int j=0;j<M;j++) {
                if (i == j) continue;
                int sum = list.get(i) + list.get(j);
                if (sum > N || visited[sum] != -1) continue;
                queue.add(sum);
                visited[sum] = 1;
                list.add(sum);
            }
        }
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int num : list) {
                int sum = now + num;
                if (sum > N || visited[sum] != -1) continue;
                queue.add(sum);
                visited[sum] = visited[now] + 1;
            }
        }
        System.out.println(visited[N]);
    }
}