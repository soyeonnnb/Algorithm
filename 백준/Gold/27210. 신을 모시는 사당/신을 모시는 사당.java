import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17:03 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken()) == 1 ? 1 : -1;
        int ans = dp(N, arr);
        for(int i=0;i<N;i++) arr[i]*=-1;
        ans = Math.max(dp(N, arr), ans);
        System.out.println(ans);
    }
    private static int dp(int N, int[] arr) {
        int sum = 0;
        int max = 0;
        for(int i=0;i<N;i++) {
            sum += arr[i];
            if (sum < 0) sum = 0;
            max = Math.max(sum, max);
        }
        max = Math.max(max,sum);
        return max;
    }
}