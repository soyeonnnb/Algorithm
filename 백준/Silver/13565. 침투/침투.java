
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};
    private static int N, M;
    private static boolean flag;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N=Integer.parseInt(st.nextToken());
         M=Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) visited[i][j] = str.charAt(j) == '1';
        }
        for(int j=0;j<M;j++) {
            if (!visited[0][j]) recur(0, j);
        }
        System.out.println(flag ? "YES" : "NO");
    }
    private static void recur(int x, int y) {
        visited[x][y] = true;
        if (flag) return;
        if (x == N-1) {
            flag = true;
            return;
        }
        for(int k=0;k<4;k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
            recur(nx, ny);
        }
    }
}
