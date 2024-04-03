import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 17:08 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) arr[i][j] = (Integer.parseInt(st.nextToken()) + 1)%2;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        boolean[][] visited = new boolean[N][M];
        int ans = 987654321;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if ((i == 0 && j == 0) || (i == N-1 && j == M-1)) continue;
                if (i != N-1 && j != 0) continue;
                visited[i][j] = true;
                queue.add(new int[]{i, j, arr[i][j]});
                if (i == 0 || j == M-1) {
                    ans = Math.min(ans, arr[i][j]);
                }
            }
        }
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k=0;k<8;k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                if ((nx == 0 && ny == 0) || (nx == N-1 && ny == M-1)) continue;
                int cost = now[2] + arr[nx][ny];
                visited[nx][ny] = true;
                if (nx == 0 || ny == M-1) {
                    ans = Math.min(ans, cost);
                    continue;
                }
                queue.add(new int[]{nx, ny, cost});
            }
        }
        System.out.println(ans);
    }
}