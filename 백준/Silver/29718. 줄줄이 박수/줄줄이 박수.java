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
        int[] arr = new int[M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) arr[j] += Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=M;i++) arr[i] += arr[i-1];
        int A = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=A;i<=M;i++) {
            ans = Math.max(ans, arr[i] - arr[i-A]);
        }
        System.out.println(ans);
    }
}
