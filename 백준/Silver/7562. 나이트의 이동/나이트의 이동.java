import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 02:24 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited;
        int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};
        outer: for(int tc=1;tc<=T;tc++) {
            int N=Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            queue.clear();
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            queue.add(new int[]{x1, y1, 0});
            visited[x1][y1] = true;
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (x1 == x2 && y1 == y2) {
                System.out.println(0);
                continue;
            }
            while(!queue.isEmpty()) {
                int[] now = queue.poll();
                for(int k=0;k<8;k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                    if (nx == x2 && ny == y2) {
                        System.out.println(now[2] + 1);
                        continue outer;
                    }
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, now[2] + 1});
                }
            }
        }
    }
}
