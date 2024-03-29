import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 01:56 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][] arr;
        boolean[][] visited;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int tc = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        while(true) {
            int N=Integer.parseInt(br.readLine());
            if (N == 0) break;
            int ans = 0;
            pq.clear();
            arr = new int[N][N];
            visited = new boolean[N][N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
            }
            pq.add(new int[]{0, 0, arr[0][0]});
            while(!pq.isEmpty()) {
                int[] now = pq.poll();
                if (visited[now[0]][now[1]]) continue;
                visited[now[0]][now[1]] = true;
                if (now[0] == N-1 && now[1] == N-1) {
                    ans = now[2];
                    break;
                }
                for(int k=0;k<4;k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                    pq.add(new int[]{nx, ny, now[2] + arr[nx][ny]});
                }
            }
            sb.append("Problem "+tc+": "+ans+"\n");
            tc++;
        }

        System.out.println(sb);
    }
}