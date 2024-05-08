import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int Q=Integer.parseInt(st.nextToken());
        int[][] arr =new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++) {
            st = new StringTokenizer(br.readLine());
            int r1=Integer.parseInt(st.nextToken());
            int c1=Integer.parseInt(st.nextToken());
            int r2=Integer.parseInt(st.nextToken());
            int c2=Integer.parseInt(st.nextToken());
            int sum = arr[r2][c2] - arr[r1-1][c2] - arr[r2][c1-1] + arr[r1-1][c1-1];
            sb.append(sum/((r2-r1+1)*(c2-c1+1))).append("\n");
        }
        System.out.println(sb);

    }
}
