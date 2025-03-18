
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, K, ans;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        visited[N-1][0] = true;

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                if (str.charAt(j) == 'T') {
                    visited[i][j] = true;
                }
            }
        }
        ans = 0;
        recur(N-1, 0, 1);
        System.out.println(ans);
    }

    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};

    private static void recur(int x, int y, int cnt) {
        if (cnt == K) {
            if (x == 0 && y == M-1) ans++;
            return;
        }

        for(int k=0;k<4;k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            recur(nx, ny, cnt+1);
            visited[nx][ny] = false;
        }
    }
}
