import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 16:04 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -2) arr[i][j] = 0;
            }
        }
        long[][] visited = new long[N][M];
        for(int i=0;i<N;i++) Arrays.fill(visited[i], -1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> visited[o1[0]][o1[1]] > visited[o2[0]][o2[1]] ? 1 : -1 );
        for(int i=1;i<N;i++) {
            for(int j=0;j<M-1;j++) {
                if (arr[i][j] == -1) continue;
                if (i != N-1 && j != 0) continue;
                visited[i][j] = arr[i][j];
                queue.add(new int[]{i, j});
            }
        }
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        long ans = -1;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k=0;k<8;k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == -1 || visited[nx][ny] != -1) continue;
                long cost = visited[now[0]][now[1]] + arr[nx][ny];
                visited[nx][ny] = cost;
                if (nx == 0 || ny == M-1) {
                    ans = ans == -1 ? cost : Math.min(ans, cost);
                    continue;
                }
                queue.add(new int[]{nx, ny});
            }
        }
        System.out.println(ans);

    }
}