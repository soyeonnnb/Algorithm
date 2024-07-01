import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] ans = new int[N+1][N+1];
        int[][] dij = new int[N+1][N+1];
        for(int i=0;i<=N;i++) Arrays.fill(dij[i], 20000000);
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            ans[u][v]=v;
            ans[v][u]=u;
            dij[u][v] = Math.min(dij[u][v], w);
            dij[v][u] = Math.min(dij[v][u], w);
        }

        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if (i == j) continue;
                    int rootK = dij[i][k] + dij[k][j];
                    if (dij[i][j] > rootK) {
                        dij[i][j] = rootK;
                        ans[i][j] = ans[i][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if (i == j) sb.append("-");
                else sb.append(ans[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}