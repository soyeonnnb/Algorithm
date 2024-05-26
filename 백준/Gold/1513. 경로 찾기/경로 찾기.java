import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 20:35 ~
public class Main {
    private static int N, M;
    private static final int MOD = 1_000_007;
    private static int[][][][] dp;
    private static int[][] entertain;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        entertain = new int[N+1][M+1];
        for(int c=1;c<=C;c++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            entertain[x][y] = c;
        }
        dp = new int[N+1][M+1][C+1][C+1];
        for(int i=0;i<=N;i++) for(int j=0;j<=M;j++) for(int k=0;k<=C;k++) Arrays.fill(dp[i][j][k], -1);
        if (entertain[1][1] != 0)
            dp[1][1][1][entertain[1][1]] = 1;
        else dp[1][1][0][0] = 1;
        StringBuilder sb = new StringBuilder();
        for(int c=0;c<=C;c++) {
            int sum = 0;
            for(int i=0;i<=C;i++) {
                sum += recur(N, M, c, i);
                sum %= MOD;
            }
            sb.append(sum).append(" ");
        }

        System.out.println(sb);

    }
    private static int[] dx = new int[]{0, -1};
    private static int[] dy = new int[]{-1, 0};

    private static int recur(int x, int y, int enter, int max) {
        if (x < 1 || y < 1 || enter < 0) return 0;
        else if (dp[x][y][enter][max] != -1) return dp[x][y][enter][max];

        dp[x][y][enter][max] = 0;
        
        // 만약 현재 위치가 오락실인데, 현재 오락실 번호가 최대값보다 작으면 패스
        if (entertain[x][y] != 0 && entertain[x][y] != max) {
            return 0;
        }

        for(int k=0;k<2;k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            // 만약 현재 위치가 오락실이라면
            if (entertain[x][y] != 0) {
                int num = entertain[x][y]; // 현재 위치의 오락실 번호
                for(int n=0;n<num;n++) {
                    dp[x][y][enter][max] += recur(nx, ny, enter-1, n);
                    dp[x][y][enter][max] %= MOD;
                }
            } else { // 만약 현재 위치가 오락실이 아니라면
                dp[x][y][enter][max] += recur(nx, ny, enter, max);
            }
            dp[x][y][enter][max] %= MOD;
        }

        return dp[x][y][enter][max];
    }
}