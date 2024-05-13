import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 13:28 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][][] dp = new int[3][N][M];
        for(int k=0;k<3;k++) for(int i=0;i<N;i++) Arrays.fill(dp[k][i], 1000000000);
        int[] dy = {-1, 1, 0};
        for(int j=0;j<M;j++) {
            for(int k=0;k<3;k++) dp[k][0][j] = arr[0][j];
        }
        for(int i=1;i<N;i++) {
            for(int j=0;j<M;j++) {
                for(int k=0;k<3;k++) {
                    int ny = j + dy[k];
                    if (ny < 0 || ny >= M) continue;
                    for(int m=0;m<3;m++) {
                        if (k == m) continue;
                        dp[k][i][j] = Math.min(dp[k][i][j], dp[m][i-1][ny] + arr[i][j]);
                    }
                }
            }
        }
        int ans = 1000000000;
        for(int j=0;j<M;j++) {
            for(int k=0;k<3;k++) {
                ans = Math.min(ans, dp[k][N-1][j]);
            }
        }
        System.out.println(ans);
    }
}