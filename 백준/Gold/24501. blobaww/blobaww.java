import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        final int MOD = 1000000007;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int[][] e = new int[N+1][M+1];
        int[][] m = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++) {
                if (arr[i-1][j-1] == 'E') e[i][j]++;
                else if (arr[i-1][j-1] == 'M') m[i][j]++;
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                e[i][j] += e[i-1][j] + e[i][j-1] - e[i-1][j-1];
                m[i][j] += m[i-1][j] + m[i][j-1] - m[i-1][j-1];
            }
        }

        long ans = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (arr[i][j] != 'S') continue;
                long res = e[i+1][j+1]; // E 누르는 경우의 수
                res *= m[N][M] - m[N][j] - m[i][M] + m[i][j];
                ans += res;
                ans %= MOD;
            }
        }
        System.out.println(ans);
    }
}