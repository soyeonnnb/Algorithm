import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for(int i=0;i<=N;i++) Arrays.fill(arr[i], -1);

        int ans = -1;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }
        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                if (arr[i][k] == -1) continue;
                for(int j=1;j<=N;j++) {
                    if (arr[k][j] == -1) continue;
                    arr[i][j] = arr[i][j] == -1 ? arr[i][k] + arr[k][j] : Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if (arr[i][j] == -1 || arr[j][i] == -1) continue;
                ans = ans == -1 ? arr[i][j] + arr[j][i] : Math.min(ans, arr[i][j] + arr[j][i]);
            }
        }
        System.out.println(ans);
    }
}