import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12:24 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] t = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) t[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) b[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) c[i] = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N][2];
        dp[0][0] = c[0];
        for(int i=1;i<N;i++) {

            if (t[i] == b[i]) dp[i][0] = c[i];
            else {
                int idx = binary(t[i]-b[i], t, N);
                if (idx == -1) dp[i][0] = c[i];
                else dp[i][0] = Math.max(dp[idx][0], dp[idx][1]) + c[i];
            }
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));

    }
    private static int binary(int num, int[] t, int N) {
        int s = 0;
        int e = N-1;
        while(s <= e) {
            int mid = (s+e) / 2;
            if (t[mid] == num) return mid-1;
            else if (t[mid] < num) s = mid + 1;
            else e = mid -1;
        }
        return e;
    }
}