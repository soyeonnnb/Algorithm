
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M=Integer.parseInt(st.nextToken());
            for(int j=0;j<M;j++) arr[i] += Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=1;i<N;i++) arr[i] += arr[i-1];
        long ans = 0;
        for(int i=0;i<N;i++) ans += arr[i];
        System.out.println(ans);
    }
}
