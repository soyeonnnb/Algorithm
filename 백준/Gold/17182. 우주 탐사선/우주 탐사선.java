import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    private static int N, ans;
    private static int[][] arr;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k=0;k<N;k++) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        
        visited = new boolean[N];
        visited[K] = true;
        ans = Integer.MAX_VALUE;
        recur(K, 0, 1);
        System.out.println(ans);
    }

    private static void recur(int cur, int length, int count) {
        if (ans < length) return;

        if (count == N) {
            ans = Math.min(length, ans);
            return;
        }

        for(int i=0;i<N;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            recur(i, length+arr[cur][i], count + 1);
            visited[i] = false;
        }
    }

}