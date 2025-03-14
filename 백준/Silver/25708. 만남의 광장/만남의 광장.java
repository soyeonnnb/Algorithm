
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
        int[][] arr = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int[] row = new int[N];
        int[] col = new int[M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                row[i] += arr[i][j];
                col[j] += arr[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int x1=0;x1<N;x1++) {
            for(int x2=x1+1;x2<N;x2++) {
                for(int y1=0;y1<M;y1++) {
                    for(int y2=y1+1;y2<M;y2++) {
                        int sum = row[x1] + row[x2] + col[y1] + col[y2] - arr[x1][y1] - arr[x1][y2] - arr[x2][y1] - arr[x2][y2];
                        sum += (x2-x1-1) * (y2-y1-1);
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
