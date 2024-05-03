import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 10:32 ~
public class Main {
    private static int N, M;
    private static int[][] arr;
    private static boolean[][] visited, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                switch (str.charAt(j)) {
                    case 'U':
                        arr[i][j] = 0;
                        break;
                    case 'R':
                        arr[i][j] = 1;
                        break;
                    case 'D':
                        arr[i][j] = 2;
                        break;
                    case 'L':
                        arr[i][j] = 3;
                        break;
                }
            }
        }
        dp = new boolean[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (visited[i][j]) continue;
                dfs(i, j);
            }
        }
        int ans = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) if (dp[i][j]) ans++;
        }
        System.out.println(ans);
    }
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};
    private static boolean dfs(int x, int y) {
        if (visited[x][y]) return dp[x][y];

        visited[x][y] = true;

        int nx = x + dx[arr[x][y]];
        int ny = y + dy[arr[x][y]];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
            dp[x][y] = true;
        } else {
            dp[x][y] = dfs(nx, ny);
        }
        return dp[x][y];
    }
}