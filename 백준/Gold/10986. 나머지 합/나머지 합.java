import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

// 13:06 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] prefix = new int[N+1];
        for(int i=1;i<=N;i++) prefix[i] = (prefix[i-1] + arr[i-1])%M;
        int[] count = new int[M];
        for(int i=0;i<=N;i++) count[prefix[i]]++;
        long ans = 0;
        for(int i=0;i<=N;i++) {
            count[prefix[i]]--;
            ans += count[prefix[i]];
        }
        System.out.println(ans);
    }
}