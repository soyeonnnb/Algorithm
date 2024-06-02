import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Long.parseLong(st.nextToken());

        // 0은 해당 노드에 개미X, 1은 해당 노드에 개미O
        // N번째 , 해당 노드에 개미 유무, 0번 노드에 개미 유무
        long[][][] dp = new long[N][2][2];
        dp[0][0][0] = arr[0];
        dp[0][1][1] = 1;
        for(int i=1;i<N;i++) {
            for(int k=0;k<2;k++) {
            dp[i][0][k] = Math.max(dp[i-1][0][k], dp[i-1][1][k]) + arr[i]; // 0은 해당 노드에 개미가 없으니까 앞에 있든말든 상관X
            dp[i][1][k] = dp[i-1][0][k] + 1; //  해당 노드에 개미가 있으니까 앞에 없는 상태에서 1개 추가
            }
        }
        System.out.println(Math.max(dp[N-1][0][0], Math.max(dp[N-1][0][1], dp[N-1][1][0])));
    }
}