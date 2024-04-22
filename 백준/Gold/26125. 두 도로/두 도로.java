import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 13:16 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int T=Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        for(int i=0;i<=N;i++) Arrays.fill(arr[i], 500000000);
        for(int i=0;i<=N;i++) arr[i][i] = 0;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            arr[u][v] = Math.min(arr[u][v], w);
        }

        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if (arr[i][k] == -1 || arr[k][j] == -1) continue;
                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int Q=Integer.parseInt(br.readLine());
        for(int q=0;q<Q;q++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            // 새로운 도로를 이용하지 않는 경우
            int ans = arr[S][T];

            // 첫번째 도로만 이용하는 경우
            ans = Math.min(ans, arr[S][a1] + c1 + arr[b1][T]);
            // 두번째 도로만 이용하는 경우
            ans = Math.min(ans, arr[S][a2] + c2 + arr[b2][T]);
            // 첫번째 도로 먼저 이용하는 경우
            ans = Math.min(ans, arr[S][a1] + c1 + arr[b1][a2] + c2 + arr[b2][T]);
            // 두번째 도로 먼저 이용하는 경우
            ans = Math.min(ans, arr[S][a2] + c2 + arr[b2][a1] + c1 + arr[b1][T]);

            if (ans >= 500000000) sb.append("-1\n");
            else sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
}