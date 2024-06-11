import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[][][][] dp = new int[N+1][10][10][10];
        for(int i=0;i<=N;i++) for(int j=0;j<10;j++) for(int k=0;k<10;k++) Arrays.fill(dp[i][j][k], -1);
        dp[0][0][0][0] = 0;
        int[][] to = new int[10][10];
        for(int i=0;i<10;i++) { // 시작 지점
            for(int j=0;j<10;j++) { // 종료 지점
                if (i == j) continue;
                if (i > j) {
                    to[i][j] = i-j; // 줄이기
                    to[i][j] = Math.min(to[i][j], 10-i+j); // 키우기
                } else { // i < j
                    to[i][j] = j-i; // 키우기
                    to[i][j] = Math.min(to[i][j], i + 10 - j); // 줄이기
                }
            }
        }
        for(int n=1;n<=N;n++) {
            for(int i=0;i<10;i++) { // 첫번째 인덕션
                for(int j=0;j<10;j++) { // 두번째 인덕션
                    for(int k=0;k<10;k++) { // 세번째 인덕션
                        if (dp[n-1][i][j][k] == -1) continue; // 이전에 켠적이 없으면 걍 넘기기
                        int induction1 = dp[n-1][i][j][k] + to[i][arr[n]];
                        int induction2 = dp[n-1][i][j][k] + to[j][arr[n]];
                        int induction3 = dp[n-1][i][j][k] + to[k][arr[n]];

                        dp[n][arr[n]][j][k] = dp[n][arr[n]][j][k] == -1 ? induction1 : Math.min(induction1, dp[n][arr[n]][j][k]);
                        dp[n][i][arr[n]][k] = dp[n][i][arr[n]][k] == -1 ? induction2 : Math.min(induction2, dp[n][i][arr[n]][k]);
                        dp[n][i][j][arr[n]] = dp[n][i][j][arr[n]] == -1 ? induction3 : Math.min(induction3, dp[n][i][j][arr[n]]);
                    }
                }
            }
        }
        int ans = 999999999;
        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                for(int k=0;k<10;k++) {
                    if (dp[N][i][j][k] == -1) continue;
                    ans = Math.min(ans, dp[N][i][j][k]);
                }
            }
        }
        System.out.println(ans);
    }
}