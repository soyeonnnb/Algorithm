import java.util.Arrays;
import java.util.Scanner;

// 19:32 ~
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] aArr = sc.next().toCharArray();
        char[] bArr = sc.next().toCharArray();
        int N=aArr.length;
        int M=bArr.length;
        int[][] dp = new int[N+1][M+1];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (aArr[i] == bArr[j]) dp[i+1][j+1] = dp[i][j] + 1;
            }
        }
        int ans = 0;
        for(int i=0;i<=N;i++) {
            for(int j=0;j<=M;j++) ans = Math.max(ans, dp[i][j]);
        }
        System.out.println(ans);
    }
}