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
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[N][M];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken())-1;
            int y=Integer.parseInt(st.nextToken())-1;
            int d=Integer.parseInt(st.nextToken());
            set(visited, x, y, d, N, M);
        }
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        queue.add(new int[]{0, 0, 0});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k=0;k<4;k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                if (nx == N-1 && ny == M-1) {
                    System.out.println("YES");
                    System.out.println(now[2]+1);
                    return;
                }
                queue.add(new int[]{nx, ny, now[2] + 1});
                visited[nx][ny] = true;
            }
        }

        System.out.println("NO");
    }

    private static void set(boolean[][] visited, int x, int y, int d, int N, int M) {
        for(int i=0;i<=d;i++) { // i 는 x의 d
            int minx = x - i;
            int maxx = x + i;
            int miny = y - (d-i);
            int maxy = y + (d-i);
            if (minx >= 0) {
                if (miny>=0) visited[minx][miny] = true;
                if (maxy<M) visited[minx][maxy] = true;
            }
            if (maxx < N) {
                if (miny>=0) visited[maxx][miny] = true;
                if (maxy<M) visited[maxx][maxy] = true;
            }

        }
    }
}