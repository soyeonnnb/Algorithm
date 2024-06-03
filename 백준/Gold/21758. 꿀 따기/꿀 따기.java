import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] prefix = new int[N+1];
        int[] suffix = new int[N];
        for(int i=1;i<N;i++) prefix[i] = arr[i] + prefix[i-1];
        for(int i=N-2;i>=0;i--) suffix[i] = arr[i] + suffix[i+1];
        int ans = 0;
        for(int i=1;i<N-1;i++) {
            ans = Math.max(ans, prefix[N-1] + prefix[N-1] - prefix[i] - arr[i]);
            ans = Math.max(ans, suffix[0] + suffix[0] - suffix[i] - arr[i]);
            ans = Math.max(ans, prefix[i] + suffix[i]);
        }

        System.out.println(ans);
    }
}