import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;
        int[] result = new int[N+1];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=N-1;i>=0;i--) {
            result[i] = Math.max(result[i], result[i+1]);
            if (i + arr[i][0] <= N) {
                result[i] = Math.max(result[i], result[i+arr[i][0]] + arr[i][1]);
            }
        }
        System.out.println(result[0]);
    }
}