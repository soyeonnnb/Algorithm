import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];
        dp[0] = 1;
        for(int i=1;i<N;i++) {
            for(int j=0;j<i;j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
        }
        int ans = 0 ;
        for(int i=0;i<N;i++) ans = Math.max(dp[i], ans);
        System.out.println(ans);
    }
}
