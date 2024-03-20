import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 일단 입력받자
        String input = sc.next();
        int M=input.length();
        char[] flag = new char[M+1];
        for(int i=1;i<=M;i++) flag[i] = input.charAt(i-1);
        input = sc.next();
        int N=input.length();
        char[][] arr = new char[N+1][2];
        for(int i=1;i<=N;i++) arr[i][0] = input.charAt(i-1);
        input = sc.next();
        for(int i=1;i<=N;i++) arr[i][1] = input.charAt(i-1);

        int[][][] dp = new int[N+1][M+1][2];
        for(int i=1;i<=N;i++) {
            for(int j=0;j<2;j++)
                if (arr[i][j] == flag[1]) dp[i][1][j] = 1;
        }
        // 각 문자열을 돌면서
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                for(int k=0;k<2;k++) { // 0, 1 먼저 시작하는거
                    if (arr[i][k] == flag[j]) {
                        // 이전 문자열까지 완성된 곳까지 다 더해주기
                        for(int l=0;l<i;l++) dp[i][j][k == 0 ? 0 : 1] += dp[l][j-1][k == 0 ? 1 : 0];
                    }
                }
            }
        }
        int ans = 0;
        // 문자열이 다 완성된거 == 2번째 인덱스가 M인거 다 더해주기
        for(int i=1;i<=N;i++) for(int k=0;k<2;k++) ans+=dp[i][M][k];
        System.out.println(ans);
    }
}
