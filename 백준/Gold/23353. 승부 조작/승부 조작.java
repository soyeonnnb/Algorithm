import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N+2][N+2];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][][][] dp = new int[4][N+2][N+2][2]; // 세로가로대각선2, 가로, 세로, prefix/suffix
        int max = 0;
        int[][] dx = new int[][]{{-1, 1}, {0, 0}, {-1, 1}, {-1, 1}};
        int[][] dy = new int[][]{{0, 0}, {-1, 1}, {-1, 1}, {1, -1}};
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if (arr[i][j] != 1) continue;
                for(int k=0;k<4;k++) {
                    dp[k][i][j][0] = dp[k][i+dx[k][0]][j+dy[k][0]][0] + 1;
                    max = Math.max(max, dp[k][i][j][0]);
                }
            }
        }
        for(int i=N;i>=1;i--) {
            for(int j=N;j>=1;j--) {
                if (arr[i][j] != 1) continue;
                for(int k=0;k<4;k++) {
                    dp[k][i][j][1] = dp[k][i+dx[k][1]][j+dy[k][1]][1] + 1;
                    max = Math.max(max, dp[k][i][j][1]);
                }
            }
        }

        for(int i=1;i<=N;i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != 2) continue;
                for(int k=0;k<4;k++) {
                    max = Math.max(max, dp[k][i+dx[k][0]][j+dy[k][0]][0] + dp[k][i+dx[k][1]][j+dy[k][1]][1] + 1);
                }
            }
        }
        System.out.println(max);
    }
}