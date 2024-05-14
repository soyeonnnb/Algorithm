import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 14:57 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[]{0, 0, 0});
        int ans = 0;
        int[] dx = new int[]{-1, 1 ,0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        boolean[][] visited = new boolean[N][N];
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if (visited[now[0]][now[1]]) continue;
            visited[now[0]][now[1]] = true;
            ans = Math.max(ans, now[2]);
            if(now[0] == N-1 && now[1] == N-1) break;
            for(int k=0;k<4;k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                pq.add(new int[]{nx, ny, Math.abs(arr[now[0]][now[1]] - arr[nx][ny])});
            }
        }

        System.out.println(ans);
    }
}