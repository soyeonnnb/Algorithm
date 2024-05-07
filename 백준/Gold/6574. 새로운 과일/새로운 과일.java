import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// 19:12 ~
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            int N=str1.length();
            int M=str2.length();
            int[][] dp = new int[N+1][M+1];
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=M;j++) {
                    if (str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
            StringBuilder sb = new StringBuilder(N+M);
            int s = N;
            int e = M;
            while(s >= 1 && e >= 1) {
                if (dp[s][e] == dp[s-1][e]) {
                    s--;
                } else if (dp[s][e] == dp[s][e-1]) {
                    e--;
                } else {
                    sb.append(str1.charAt(s-1));
                    s--;
                    e--;
                }
            }
            String combine = sb.reverse().toString();
            sb = new StringBuilder();
            s = 0;
            e = 0;
            int idx = 0;
            while(s < N && e < M && idx < combine.length()) {
                if (str1.charAt(s) == combine.charAt(idx) && str2.charAt(e) == combine.charAt(idx)) {
                    sb.append(combine.charAt(idx++));
                    s++;
                    e++;
                } else if (str1.charAt(s) == combine.charAt(idx)) {
                    sb.append(str2.charAt(e++));
                } else if (str2.charAt(e) == combine.charAt(idx)) {
                    sb.append(str1.charAt(s++));
                } else {
                    sb.append(str2.charAt(e++));
                }
            }
            while(s < N) sb.append(str1.charAt(s++));
            while(e < M) sb.append(str2.charAt(e++));
            System.out.println(sb);
        }
    }
}