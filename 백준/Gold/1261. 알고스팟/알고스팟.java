import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 20:20 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        if (M == 1 && N == 1){
            System.out.println(0);
            return;
        }
        int[][] arr = new int[N][M];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) arr[i][j] = str.charAt(j) - '0';
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]); // x, y, 부순 횟수
        pq.add(new int[]{0, 0, 0});
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int ans = N*M;
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        outer: while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[2] >= ans) break;
            for(int k=0;k<4;k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                if (nx == N-1 && ny == M-1) {
                    ans = now[2];
                    break outer;
                }
                pq.add(new int[]{nx, ny, now[2] + arr[nx][ny]});
                visited[nx][ny] = true;
            }
        }
        System.out.println(ans);

    }
}