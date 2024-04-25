import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11:28 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int P=Integer.parseInt(st.nextToken());
            int Q=Integer.parseInt(st.nextToken());
            int[] people= new int[N];
            for(int i=0;i<N;i++) people[i] = Integer.parseInt(br.readLine());
            int[][] arr = new int[P+1][P+1];
            for(int i=0;i<=P;i++) Arrays.fill(arr[i], 10000000);
            for(int i=0;i<=P;i++) arr[i][i]=0;
            for(int i=0;i<Q;i++) {
                st = new StringTokenizer(br.readLine());
                int u=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());
                int w=Integer.parseInt(st.nextToken());
                arr[u][v] = Math.min(arr[u][v], w);
                arr[v][u] = Math.min(arr[v][u], w);
            }

            for(int k=1;k<=P;k++) {
                for(int i=1;i<=P;i++) {
                    for(int j=1;j<=P;j++) {
                        arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                    }
                }
            }

            long ans = -1;
            int idx = -1;
            outer: for(int i=1;i<=P;i++) {
                long sum = 0;
                for(int j=0;j<N;j++) {
                    if (arr[i][people[j]] == 10000000) continue outer;
                    sum += (arr[i][people[j]])*(arr[i][people[j]]);
                    if (idx != -1 && sum > ans) continue outer;
                }
                if (idx == -1 || ans > sum) {
                    idx = i;
                    ans = sum;
                }
            }
            sb.append(idx).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}