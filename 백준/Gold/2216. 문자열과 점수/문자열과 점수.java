import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        char[] xArr = br.readLine().toCharArray();
        char[] yArr = br.readLine().toCharArray();
        int N=xArr.length;
        int M=yArr.length;
        long[][] dp = new long[N+1][M+1]; // 1~i, 1~j까지 했을 때의 최대 점수
        for(int i=0;i<=N;i++) Arrays.fill(dp[i], -2100000000);
        for(int i=0;i<=N;i++) {
            for(int j=0;j<=M;j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                }else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + B;
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + B;
                } else {
                    if (xArr[i-1] == yArr[j-1]) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + A);
                    // i가 공백이랑 연결되는 경우
                    dp[i][j] =  Math.max(dp[i][j], dp[i-1][j] + B);
                    // j가 공백이랑 연결되는 경우
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + B);
                    // 둘이 다른걸로 연결되는 경우
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + C);
                }
            }
        }
        System.out.println(dp[N][M]);

    }
}